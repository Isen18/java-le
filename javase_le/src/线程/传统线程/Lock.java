package 线程.传统线程;

/**
 * @author Isen
 * @date 2018/11/5 20:55
 * @since 1.0
 */
public class Lock {

    private boolean isLocked = false;
    private Thread lockingThread = null;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        notify();
    }
}
