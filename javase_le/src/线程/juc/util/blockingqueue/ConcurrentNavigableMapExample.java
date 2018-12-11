package 线程.juc.util.blockingqueue;

import java.util.Collections;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author Isen
 * @date 2018/11/16 14:52
 * @since 1.0
 */
public class ConcurrentNavigableMapExample {

    public static void main(String[] args) {
        ConcurrentNavigableMap map = new ConcurrentSkipListMap();

        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        ConcurrentNavigableMap headMap = map.headMap("2");
        System.out.println(headMap);

        map.put("0", "three");
        System.out.println(headMap);

        ConcurrentNavigableMap tailMap = map.tailMap("2");
        System.out.println(tailMap);

        ConcurrentNavigableMap subMap = map.subMap("2", "3");
    }
}
