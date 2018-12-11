package 线程.juc.util.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Isen
 * @date 2018/11/16 11:37
 * @since 1.0
 */
public class PriorityBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue   = new PriorityBlockingQueue();

        //String implements java.lang.Comparable
        queue.put("Value");

        String value = queue.take();
        System.out.println(value);
    }
}
