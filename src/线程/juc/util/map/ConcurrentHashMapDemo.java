package 线程.juc.util.map;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Isen
 * @date 2018/11/18 16:34
 * @since 1.0
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    concurrentHashMap.put(i, "value" + i);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    concurrentHashMap.put(i, "value2" + i);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for(Entry<Integer, String> entry : concurrentHashMap.entrySet()){
                    System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
                }
            }
        }.start();
    }
}
