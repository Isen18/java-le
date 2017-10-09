package 线程池;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

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
        ExecutorService pool = Executors.newFixedThreadPool(2);
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
        pool.execute(te);
        // 关闭线程池
        pool.shutdown();
    }
}

class MyThread_2 extends Thread {

    @Override
    public void run() {
    	try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread().getName()+ " is running.");
    }
}