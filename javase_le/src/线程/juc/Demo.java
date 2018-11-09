package 线程.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author Isen
 * @date 2018/10/31 23:13
 * @since 1.0
 */
public class Demo {
    Lock lock;
    ReentrantLock reentrantLock;
    LockSupport lockSupport;
    Condition condition;
    AbstractOwnableSynchronizer abstractOwnableSynchronizer;
    AbstractQueuedSynchronizer abstractQueuedSynchronizer;
    AbstractQueuedLongSynchronizer abstractQueuedLongSynchronizer;
    ReadWriteLock readWriteLock;
    ReentrantReadWriteLock reentrantReadWriteLock;
    CountDownLatch countDownLatch;
    CyclicBarrier cyclicBarrier;
    Semaphore semaphore;
    ReadLock readLock;
}
