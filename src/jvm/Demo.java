package jvm;

/**
 * @author Isen
 * @date 2019/2/12 17:41
 * @since 1.0
 */
public class Demo {
    static Object monitor1 = new Object();
    static Object monitor2 = new Object();

    public static void main(String[] args) {
//        Math.addExact(, )

        new Thread("thread1"){
            @Override
            public void run() {
                synchronized(monitor1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (monitor2){
                        System.out.println("thread1 获取锁");
                    }
                }
            }

        }.start();

        new Thread("thread2"){
            @Override
            public void run() {
                synchronized(monitor2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (monitor1){
                        System.out.println("thread2 获取锁");
                    }
                }
            }
        }.start();
    }
}
