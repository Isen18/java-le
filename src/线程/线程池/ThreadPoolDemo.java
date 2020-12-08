package 线程.线程池;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
//	Executors
//	Executor
//	ExecutorService
//	AbstractExecutorService
//	ThreadPoolExecutor
//	ScheduledExecutorService
//	ScheduledThreadPoolExecutor
//	Integer
//	FutureTask<V>
//	Future<V>
//	RunnableFuture<V>
	
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(1);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread ta = new MyThread_2();
        Thread tb = new MyThread_2();
        Thread tc = new MyThread_2();
        Thread td = new MyThread_2();
        Thread te = new MyThread_2();
        // 将线程放入池中进行执行
        pool.execute(ta);
        pool.execute(tb);
        pool.execute(tc);
        pool.execute(td);
        // 关闭线程池
        pool.shutdown();
        System.out.println("shutdown");
        pool.shutdownNow();
        System.out.println("shutdownNow");
        pool.execute(te);
//        List<Runnable> runnables =  pool.shutdownNow();
//        System.out.println(runnables);
    }
}

class MyThread_2 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " start.");
    	try {
//            int r = new Random().nextInt(5) + 1;
//			sleep(1000 * r);
//			System.out.println("r=" + r);
            sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread().getName()+ " end.");
    }
}