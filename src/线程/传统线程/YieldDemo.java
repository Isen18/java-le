package 线程.传统线程;

/**
 * @author Isen
 * @date 2018/10/26 17:19
 * @since 1.0
 */
public class YieldDemo {
    private static Object monitor = new Object();

    static class MyThread extends Thread{

        @Override
        public void run() {
//            synchronized (monitor){//加入此条件，无法实现让出
                for (int i = 0; i < 20; i++) {
                    if(i % 5 == 0){
                        System.out.println(this.getName() + " 让出cpu");
                        Thread.yield();
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
