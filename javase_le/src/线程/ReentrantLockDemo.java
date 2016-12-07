package 线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 	// 创建一个 ReentrantLock ，默认是“非公平锁”。
	ReentrantLock()
	// 创建策略是fair的 ReentrantLock。fair为true表示是公平锁，fair为false表示是非公平锁。
	ReentrantLock(boolean fair)
	// 查询当前线程保持此锁的次数。
	int getHoldCount()
	// 返回目前拥有此锁的线程，如果此锁不被任何线程拥有，则返回 null。
	protected Thread getOwner()
	// 返回一个 collection，它包含可能正等待获取此锁的线程。
	protected Collection<Thread> getQueuedThreads()
	// 返回正等待获取此锁的线程估计数。
	int getQueueLength()
	// 返回一个 collection，它包含可能正在等待与此锁相关给定条件的那些线程。
	protected Collection<Thread> getWaitingThreads(Condition condition)
	// 返回等待与此锁相关的给定条件的线程估计数。
	int getWaitQueueLength(Condition condition)
	// 查询给定线程是否正在等待获取此锁。
	boolean hasQueuedThread(Thread thread)
	// 查询是否有些线程正在等待获取此锁。
	boolean hasQueuedThreads()
	// 查询是否有些线程正在等待与此锁有关的给定条件。
	boolean hasWaiters(Condition condition)
	// 如果是“公平锁”返回true，否则返回false。
	boolean isFair()
	// 查询当前线程是否保持此锁。
	boolean isHeldByCurrentThread()
	// 查询此锁是否由任意线程保持。
	boolean isLocked()
	// 获取锁。
	void lock()
	// 如果当前线程未被中断，则获取锁。
	void lockInterruptibly()
	// 返回用来与此 Lock 实例一起使用的 Condition 实例。
	Condition newCondition()
	// 仅在调用时锁未被另一个线程保持的情况下，才获取该锁。
	boolean tryLock()
	// 如果锁在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁。
	boolean tryLock(long timeout, TimeUnit unit)
	// 试图释放此锁。
	void unlock()
 */
/**
 * 
 *<p>Title: ReentrantLockDemo</p>
 *<p>Description: </p>
 * @author zhyi
 * @data 2016年12月7日
 * @time 下午4:14:02
 * @version 1.0
 *
 */
public class ReentrantLockDemo {
	public static void lockTest() {  
        Depot mDepot = new Depot();
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
	public static void lockTest2() {  
		Depot2 mDepot2 = new Depot2(100);
		Producer2 mPro = new Producer2(mDepot2);
		Customer2 mCus = new Customer2(mDepot2);
		
		mPro.produce(60);
		mPro.produce(120);
		mCus.consume(90);
		mCus.consume(150);
		mPro.produce(110);
	}
	public static void main(String[] args) {
//		lockTest();
		lockTest2();
	}
}

// 仓库
/**
 * 
 *<p>Title: Depot</p>
 *<p>Description: 这个模型存在两个问题：
	(01) 现实中，仓库的容量不可能为负数。但是，此模型中的仓库容量可以为负数，这与现实相矛盾！
	(02) 现实中，仓库的容量是有限制的。但是，此模型中的容量确实没有限制的！</p>
 * @author zhyi
 * @data 2016年12月7日
 * @time 下午4:16:54
 * @version 1.0
 *
 */
class Depot { 
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Depot() {
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    public void produce(int val) {
        lock.lock();
        try {
            size += val;
            System.out.printf("%s produce(%d) --> size=%d\n", 
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            size -= val;
            System.out.printf("%s consume(%d) <-- size=%d\n", 
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }
}; 

// 生产者
class Producer {
    private Depot depot;
    
    public Producer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}

// 消费者
class Customer {
    private Depot depot;
    
    public Customer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}

// 仓库
/**
 * 
 *<p>Title: Depot2</p>
 *<p>Description: Condition是需要和Lock联合使用的：通过Condition中的await()方法，能让线程阻塞[类似于wait()]；
 *	通过Condition的signal()方法，能让唤醒线程[类似于notify()]。</p>
 * @author zhyi
 * @data 2016年12月7日
 * @time 下午4:18:44
 * @version 1.0
 *
 */
class Depot2 {
    private int capacity;    // 仓库的容量
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁
    private Condition fullCondtion;            // 生产条件
    private Condition emptyCondtion;        // 消费条件

    public Depot2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.lock = new ReentrantLock();
        this.fullCondtion = lock.newCondition();
        this.emptyCondtion = lock.newCondition();
    }

    public void produce(int val) {
        lock.lock();
        try {
             // left 表示“想要生产的数量”(有可能生产量太多，需多此生产)
            int left = val;
            while (left > 0) {
                // 库存已满时，等待“消费者”消费产品。
                while (size >= capacity)
                    fullCondtion.await();
                // 获取“实际生产的数量”(即库存中新增的数量)
                // 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
                // 否则“实际增量”=“想要生产的数量”
                int inc = (size+left)>capacity ? (capacity-size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n", 
                        Thread.currentThread().getName(), val, left, inc, size);
                // 通知“消费者”可以消费了。
                emptyCondtion.signal();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            // left 表示“客户要消费数量”(有可能消费量太大，库存不够，需多此消费)
            int left = val;
            while (left > 0) {
                // 库存为0时，等待“生产者”生产产品。
                while (size <= 0)
                    emptyCondtion.await();
                // 获取“实际消费的数量”(即库存中实际减少的数量)
                // 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
                // 否则，“实际消费量”=“客户要消费的数量”。
                int dec = (size<left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n", 
                        Thread.currentThread().getName(), val, left, dec, size);
                fullCondtion.signal();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public String toString() {
        return "capacity:"+capacity+", actual size:"+size;
    }
}; 


//生产者
class Producer2 {
 private Depot2 depot2;
 
 public Producer2(Depot2 depot2) {
     this.depot2 = depot2;
 }

 // 消费产品：新建一个线程向仓库中生产产品。
 public void produce(final int val) {
     new Thread() {
         public void run() {
             depot2.produce(val);
         }
     }.start();
 }
}

//消费者
class Customer2 {
 private Depot2 depot2;
 
 public Customer2(Depot2 depot2) {
     this.depot2 = depot2;
 }

 // 消费产品：新建一个线程从仓库中消费产品。
 public void consume(final int val) {
     new Thread() {
         public void run() {
             depot2.consume(val);
         }
     }.start();
 }
}


