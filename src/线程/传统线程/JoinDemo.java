package 线程.传统线程;

/**
 * @author Isen
 * @date 2018/10/26 17:56
 * @since 1.0
 */
public class JoinDemo {
    static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("JoinDemo is running");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("JoinDemo is runned");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join();//main线程将会阻塞此处，等待myThread执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("myThread 执行完毕，main开始执行");
    }
}
