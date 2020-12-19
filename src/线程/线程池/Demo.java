package 线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Isen
 * @date 2019/2/17 19:54
 * @since 1.0
 */
public class Demo {

    public static void main(String[] args) {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
//        fixedThreadPool.execute(() -> {
//            throw new RuntimeException(Thread.currentThread().getName() + " 异常终止");
//        });
//
//        fixedThreadPool.execute(() -> {
//            throw new RuntimeException(Thread.currentThread().getName() + " 异常终止");
//        });

//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        singleThreadExecutor.execute(() -> {
//            throw new RuntimeException(Thread.currentThread().getName() + " 异常终止");
//        });
//
//        singleThreadExecutor.execute(() -> {
//            throw new RuntimeException(Thread.currentThread().getName() + " 异常终止");
//        });

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        //以固定的周期执行,如果上个任务还未执行完,则等待
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            int idx = atomicInteger.getAndIncrement();
//            System.out.println("scheduleAtFixedRate" + idx + ":" + System.currentTimeMillis() / 1000);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("scheduleAtFixedRate" + idx + ":" + System.currentTimeMillis() / 1000);
//        }, 1, 3, TimeUnit.SECONDS);

        //以固定的延时执行, 任务之间的间隔=delay. 下个任务执行时间=上个任务执行完毕时间 + delay
//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            int idx = atomicInteger.getAndIncrement();
//            System.out.println("scheduleWithFixedDelay" + idx + ":" + System.currentTimeMillis() / 1000);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("scheduleWithFixedDelay" + idx + ":" + System.currentTimeMillis() / 1000);
//        }, 1, 3, TimeUnit.SECONDS);

        testShutDown();
    }

    public static void testShutDown() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        fixedThreadPool.execute(() -> {
            int i = 0;
            while (i < 1008) {
            }
            System.out.println("ok");
        });

        fixedThreadPool.execute(() -> {
            int i = 0;
            while (i++ < 1000) {
            }
            System.out.println("ok2");
        });

        fixedThreadPool.shutdown();
        System.out.println("finish");
//        fixedThreadPool.shutdownNow();

        System.exit(1);
    }
}
