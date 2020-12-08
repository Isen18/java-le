package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Isen
 * @date 2019/2/12 17:41
 * @since 1.0
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();

        while(true){
            list.add(new HeapOOM());
        }
    }
}
