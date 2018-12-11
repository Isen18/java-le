package 线程.juc.util.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Isen
 * @date 2018/11/16 10:12
 * @since 1.0
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws Exception {
        //容量不可更改
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
