package jvm.jvmtools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Isen
 * @date 2019/2/13 9:21
 * @since 1.0
 */
public class ThreadWait {

    /**
     * 线程死循环
     */
    public static void createBusyThread(){
        new Thread(() -> {
            while(true){
            }
        }, "createBusyThread").start();
    }

    /**
     * 活锁
     * @param lock
     */
    public static void createLockThread(final Object lock){
        new Thread(() -> {
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "createLockThread").start();
    }

    /**
     * 死锁
     */
    public static void createDeadLockThread(final Object lock1, final Object lock2){
        new Thread(() -> {
            synchronized (lock1){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){

                }
            }
        }, "createDeadLockThread1").start();

        new Thread(() -> {
            synchronized (lock2){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){

                }
            }
        }, "createDeadLockThread2").start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
        createBusyThread();

//        br.readLine();
        createLockThread(new Object());

//        br.readLine();
        createDeadLockThread(new Object(), new Object());
    }
}
