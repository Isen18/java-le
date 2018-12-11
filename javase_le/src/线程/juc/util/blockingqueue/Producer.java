package 线程.juc.util.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author Isen
 * @date 2018/11/16 10:13
 * @since 1.0
 */
public class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}