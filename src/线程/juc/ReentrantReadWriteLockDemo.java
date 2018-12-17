package 线程.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 	ReadWriteLock，顾名思义，是读写锁。它维护了一对相关的锁 — — “读取锁”和“写入锁”，一个用于读取操作，另一个用于写入操作。
	“读取锁”用于只读操作，它是“共享锁”，能同时被多个线程获取。
	“写入锁”用于写入操作，它是“独占锁”，写入锁只能被一个线程锁获取。
	注意：不能同时存在读取锁和写入锁！
	ReadWriteLock是一个接口。ReentrantReadWriteLock是它的实现类，ReentrantReadWriteLock包括子类ReadLock和WriteLock。
 */
/**
 * 
 *<p>Title: ReentrantReadWriteLockDemo</p>
 *<p>Description: </p>
 * @author zhyi
 * @data 2016年12月8日
 * @time 下午3:33:08
 * @version 1.0
 *
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) { 
        // 创建账户
        MyCount myCount = new MyCount("4238920615242830", 10000); 
        // 创建用户，并指定账户
        User user = new User("Tommy", myCount); 

        // 分别启动3个“读取账户金钱”的线程 和 3个“设置账户金钱”的线程
        for (int i=0; i<3; i++) {
        	for(int j=0;j<5;j++){
        		user.getCash();
        	}
            user.setCash((i+1)*1000);
        }
        
        
    } 
} 

class User {
    private String name;            //用户名 
    private MyCount myCount;        //所要操作的账户 
    private ReadWriteLock myLock;   //执行操作所需的锁对象 

    User(String name, MyCount myCount) {
        this.name = name; 
        this.myCount = myCount; 
        this.myLock = new ReentrantReadWriteLock();
    }

    public void getCash() {
        new Thread() {
            public void run() {
                myLock.readLock().lock(); 
                try {
                    System.out.println(Thread.currentThread().getName() +" getCash start"); 
                    myCount.getCash();
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() +" getCash end"); 
                } catch (InterruptedException e) {
                } finally {
                    myLock.readLock().unlock(); 
                }
            }
        }.start();
    }

    public void setCash(final int cash) {
        new Thread() {
            public void run() {
                myLock.writeLock().lock(); 
                try {
                    System.out.println(Thread.currentThread().getName() +" setCash start"); 
                    myCount.setCash(cash);
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() +" setCash end"); 
                } catch (InterruptedException e) {
                } finally {
                    myLock.writeLock().unlock(); 
                }
            }
        }.start();
    }
}

class MyCount {
    private String id;         //账号 
    private int    cash;       //账户余额 

    MyCount(String id, int cash) { 
        this.id = id; 
        this.cash = cash; 
    } 

    public String getId() { 
        return id; 
    } 

    public void setId(String id) { 
        this.id = id; 
    } 

    public int getCash() { 
        System.out.println(Thread.currentThread().getName() +" getCash cash="+ cash); 
        return cash; 
    } 

    public void setCash(int cash) { 
        System.out.println(Thread.currentThread().getName() +" setCash cash="+ cash); 
        this.cash = cash; 
    } 
}