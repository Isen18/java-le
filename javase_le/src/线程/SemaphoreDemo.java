package 线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 	Semaphore是一个计数信号量，它的本质是一个"共享锁"。
	信号量维护了一个信号量许可集。线程可以通过调用acquire()来获取信号量的许可；当信号量中有可用的许可时，线程能获取该许可；
	否则线程必须等待，直到有可用的许可为止。 线程可以通过release()来释放它所持有的信号量许可。
 */
/**
 * 
 *<p>Title: SemaphoreDemo</p>
 *<p>Description: </p>
 * @author zhyi
 * @data 2016年12月8日
 * @time 下午7:21:02
 * @version 1.0
 *
 */
public class SemaphoreDemo {
    private static final int SEM_MAX = 10;
    public static void main(String[] args) { 
        Semaphore sem = new Semaphore(SEM_MAX);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //在线程池中执行任务
        threadPool.execute(new MyThread_1(sem, 5));
        threadPool.execute(new MyThread_1(sem, 7));
        threadPool.execute(new MyThread_1(sem, 4));
        //关闭池
        threadPool.shutdown();
    }
}

class MyThread_1 extends Thread {
    private volatile Semaphore sem;    // 信号量
    private int count;        // 申请信号量的大小 

    MyThread_1(Semaphore sem, int count) {
        this.sem = sem;
        this.count = count;
    }

    public void run() {
        try {
            // 从信号量中获取count个许可
            sem.acquire(count);

            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " acquire count="+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放给定数目的许可，将其返回到信号量。
            sem.release(count);
            System.out.println(Thread.currentThread().getName() + " release " + count + "");
        }
    }
}