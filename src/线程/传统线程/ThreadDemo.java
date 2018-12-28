package 线程.传统线程;

public class ThreadDemo {
//	Runnable
//	Thread
//	Object
//	ThreadLocal<T>
//	Object
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new MyThreadGroup("我的线程组"), "我的线程"){
                @Override
                public void run() {
//                    try {
//                        sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    int a = 10 / 0;
                }
            };

            //默认线程异常处理
//            Thread.setDefaultUncaughtExceptionHandler((Thread t2, Throwable e) -> {
//                System.out.println("默认线程异常处理");
//            });
//            t.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){
//
//                @Override
//                public void uncaughtException(Thread t, Throwable e) {
//                    System.out.println("对象的异常处理");
//                }
//            });
            t.start();

//        }

    }
}

class MyThreadGroup extends ThreadGroup{

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
//        super.uncaughtException(t, e);
        //其中一个线程抛出异常，所有组内所有线程均中断
        System.out.println("线程组的异常处理");
        this.interrupt();
    }
}