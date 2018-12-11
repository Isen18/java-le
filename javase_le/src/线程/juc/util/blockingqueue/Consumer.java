package 线程.juc.util.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author Isen
 * @date 2018/11/16 10:20
 * @since 1.0
 */
public class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
