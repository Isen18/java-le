package 线程.传统线程;

/**
 * @author Isen
 * @date 2018/10/26 14:39
 * @since 1.0
 */
public class StartRunDemo {
    static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "调用了run");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        //通过调用start启动一个新线程，自动执行run
        myThread.start();

        //在当前线程执行run
        myThread.run();
    }
}
