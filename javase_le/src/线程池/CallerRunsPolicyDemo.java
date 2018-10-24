package 线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 
 *<p>Title: CallerRunsPolicyDemo</p>
 *<p>Description: </p>
 *将"线程池的拒绝策略"由DiscardPolicy修改为CallerRunsPolicy之后，当有任务添加到线程池被拒绝时，线程池会将被拒绝的任务添加到"线程池正在运行的线程"中取运行。
 * @author zhyi
 * @data 2016年12月9日
 * @time 上午11:01:00
 * @version 1.0
 *
 */
public class CallerRunsPolicyDemo {
    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;

    public static void main(String[] args) throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"CallerRunsPolicy"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable_4("task-"+i);
            pool.execute(myrun);
        }

        // 关闭线程池
        pool.shutdown();

        System.out.println("finished");
    }
}

class MyRunnable_4 implements Runnable {
    private String name;
    public MyRunnable_4(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " execute the task:" + this.name);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
