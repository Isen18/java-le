package 线程.传统线程;

public class ThreadDemo {
//	Runnable
//	Thread
//	Object
//	ThreadLocal<T>
//	Object
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
