package 线程.juc.util.blockingqueue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Isen
 * @date 2018/11/16 14:43
 * @since 1.0
 */
public class ConcurrentHashMapExample {

    public static void main(String[] args) {
        ConcurrentMap concurrentMap = new ConcurrentHashMap();

        concurrentMap.put("key", "value");

        Object value = concurrentMap.get("key");
        System.out.println(value);
    }
}
