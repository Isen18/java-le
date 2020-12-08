package 线程.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 
 *<p>Title: AbortPolicyDemo</p>
 *<p>Description: </p>
 *将"线程池的拒绝策略"由DiscardPolicy修改为AbortPolicy之后，当有任务添加到线程池被拒绝时，会抛出RejectedExecutionException。

 
 * @author zhyi
 * @data 2016年12月9日
 * @time 上午10:58:04
 * @version 1.0
 *
 */
public class AbortPolicyDemo {
    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;

    public static void main(String[] args) throws Exception {
        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程.线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"抛出异常"
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 设置线程池的拒绝策略为"丢弃"
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        // 设置线程池的拒绝策略为"DiscardOldestPolicy"
        //pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        // 设置线程池的拒绝策略为"CallerRunsPolicy"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        try {

            // 新建10个任务，并将它们添加到线程池中。
            for (int i = 0; i < 5; i++) {
                Runnable myrun = new MyRunnable_3("task-"+i);
                pool.execute(myrun);
            }
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
            // 关闭线程池
            pool.shutdown();
        }
    }
}

class MyRunnable_3 implements Runnable {
    private String name;
    public MyRunnable_3(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " name=" + this.name + " is running.");
            Thread.sleep(2000);
            System.out.println(this.name + " is finished.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}