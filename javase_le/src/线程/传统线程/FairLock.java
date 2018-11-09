package 线程.传统线程;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过一个等待队列实现公平机制。每个调用lock()的线程将会进入等待队列，
 * 只有队头的线程被允许锁定FairLock实例。所有其他线程都会等待，直到它们
 * 到达队头。
 *
 * 为每个线程分配一个专门且只用于唤醒它的监控器，可实现唤醒指定线程。
 *
 * @author Isen
 * @date 2018/11/5 20:54
 * @since 1.0
 */
public class FairLock {

    /**
     * 是否已经被加锁
     */
    private boolean isLocked = false;
    /**
     * 允许执行的线程
     */
    private Thread lockingThread = null;
    /**
     * 等待队列
     */
    private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        //是否锁定当前线程
        boolean isLockedForThisThread = true;
        synchronized (this) {
            waitingThreads.add(queueObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try {
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queueObject);
                }
                throw e;
            }
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }
}

/**
 * 相当于信号量，用于保存notify信号，避免丢失信号
 */
class QueueObject {

    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            this.wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}
