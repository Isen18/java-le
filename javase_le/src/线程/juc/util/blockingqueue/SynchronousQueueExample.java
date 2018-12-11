package 线程.juc.util.blockingqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Isen
 * @date 2018/11/16 11:42
 * @since 1.0
 */
public class SynchronousQueueExample {

    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue();

        new Thread(){
            @Override
            public void run() {
                try {
                    queue.put("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    String str = queue.take();
                    System.out.println("str=" + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
