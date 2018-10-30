package 线程.传统线程;

/**
 * @author Isen
 * @date 2018/10/26 16:30
 * @since 1.0
 */
public class ObjectDemo {
    private static Object monitor = new Object();

    private static volatile boolean condition = false;

    static class MyThread extends Thread{

        @Override
        public void run() {
            synchronized (monitor){
                System.out.println(this.getName() + " MyThread run 获取得锁monitor");
                while (!condition){
                    try {
                        System.out.println(this.getName() + " MyThread run 调用wait，释放锁monitor，并且进入等待状态");
                        monitor.wait();
                        System.out.println(this.getName() + " MyThread run 重新获取锁获取得锁monitor");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(this.getName() + " MyThread run 处理剩余业务逻辑");
                //根据实际需要，调用一下notify或者notifyAll
            }
        }
    }

    static class MyThread2 extends Thread{

        @Override
        public void run() {
            synchronized (monitor){
                System.out.println(this.getName() + " MyThread2 run 获取得锁monitor，并处理业务逻辑");

                System.out.println(this.getName() + " 设置condition为true，调用notify, 唤醒一个等待线程");
                condition = true;
                monitor.notify();
//                System.out.println(this.getName() + " 处理完业务逻辑，调用notifyAll, 唤醒所有等待线程");
//                monitor.notifyAll();
                System.out.println(this.getName() + " 只有程序退出该同步块，被唤醒的线程，才有可能获取锁monitor");
            }
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread2().start();
    }
}
