package 线程池;


import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MyCallable implements Callable {

    @Override 
    public Integer call() throws Exception {
        int sum    = 0;
        // 执行任务
        for (int i=0; i<100; i++)
            sum += i;
        //return sum; 
        Thread.sleep(5000);
        return Integer.valueOf(sum);
    } 
}

public class CallableDemo {

    public static void main(String[] args) 
        throws ExecutionException, InterruptedException{
        //创建一个线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //创建有返回值的任务
        Callable c1 = new MyCallable();
        //执行任务并获取Future对象 
        Future f1 = pool.submit(c1);
//        Future<String> future = pool.submit(new Callable<String>() {
//
//            @Override
//            public String call() throws Exception {
//                return "";
//            }
//        });

        // 输出结果
//        try {
//			System.out.println(f1.get(1000,TimeUnit.MILLISECONDS));
//		} catch (TimeoutException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        });

        pool.execute(futureTask);

        String re = futureTask.get();

        System.out.println(f1.get());
        //关闭线程池 
        pool.shutdown(); 
    }
}