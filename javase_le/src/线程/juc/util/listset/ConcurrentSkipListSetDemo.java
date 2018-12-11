package 线程.juc.util.listset;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author Isen
 * @date 2018/12/11 16:55
 * @since 1.0
 */
public class ConcurrentSkipListSetDemo {

    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

        set.add(1);
    }
}
