package 线程.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 
 *<p>Title: DiscardOldestPolicyDemo</p>
 *<p>Description: </p>
 *将"线程池的拒绝策略"由DiscardPolicy修改为DiscardOldestPolicy之后，当有任务添加到线程池被拒绝时，线程池会丢弃阻塞队列中末尾的任务，然后将被拒绝的任务添加到末尾。
 * @author zhyi
 * @data 2016年12月9日
 * @time 上午10:55:56
 * @version 1.0
 *
 */
public class DiscardOldestPolicyDemo {
    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;

    public static void main(String[] args) throws Exception {
        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程.线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"DiscardOldestPolicy"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable_2("task-"+i);
            pool.execute(myrun);
        }
        // 关闭线程池
        pool.shutdown();
    }
}

	class MyRunnable_2 implements Runnable {
	    private String name;
	    public MyRunnable_2(String name) {
	        this.name = name;
	    }
	    @Override
	    public void run() {
	        try {
	            System.out.println(this.name + " is running.");
	            Thread.sleep(200);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}