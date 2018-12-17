package 泛型;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Improve
 *
 * @author Isen
 * @description
 * @date 2018/7/30 11:02
 **/
public class Improve {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        System.out.println("list的类型=" + list.getClass());
        System.out.println("list2的类型=" + list2.getClass());
        //结论：
        //list的类型=class java.util.ArrayList
        //list2的类型=class java.util.ArrayList
    }
}
