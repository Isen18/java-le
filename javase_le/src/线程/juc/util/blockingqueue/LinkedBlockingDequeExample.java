package 线程.juc.util.blockingqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Isen
 * @date 2018/11/16 14:34
 * @since 1.0
 */
public class LinkedBlockingDequeExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<String>();

        deque.addFirst("1");
        deque.addLast("2");

        String two = deque.takeLast();
        String one = deque.takeFirst();

        System.out.println("two=" + two + " one=" + one);
    }
}
