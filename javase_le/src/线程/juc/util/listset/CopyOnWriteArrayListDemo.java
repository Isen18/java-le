package 线程.juc.util.listset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Isen
 * @date 2018/11/16 16:47
 * @since 1.0
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList(Arrays.asList(1, 2, 3));

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    //加锁、copy
                    copyOnWriteArrayList.add(i);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    //加锁、copy
                    copyOnWriteArrayList.add(i);
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                //无锁、访问快照
                Iterator iterator = copyOnWriteArrayList.iterator();
                while(iterator.hasNext()){
                    System.out.print(iterator.next() + " ");
                }
            }
        }.start();
    }
}
