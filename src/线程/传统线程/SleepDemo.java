package 线程.传统线程;

/**
 * @author Isen
 * @date 2018/10/26 17:39
 * @since 1.0
 */
public class SleepDemo {
    private static Object monitor = new Object();

    static class MyThread extends Thread{

        @Override
        public void run() {
//            synchronized (monitor){//加入此条件，在休眠期间不会释放锁
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println(this.getName() + "进入休眠");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " i=" + i);
            }
//            }
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }
}
