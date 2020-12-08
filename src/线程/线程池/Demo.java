package 线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(() -> {
            throw new RuntimeException(Thread.currentThread().getName() + " 异常终止");
        });

        singleThreadExecutor.execute(() -> {
            throw new RuntimeException(Thread.currentThread().getName() + " 异常终止");
        });
    }
}
