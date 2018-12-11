package 线程.juc.util.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Isen
 * @date 2018/11/16 11:31
 * @since 1.0
 */
public class LinkedBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
        BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);

        bounded.put("Value");

        String value = bounded.take();
        System.out.println(value);
    }
}
