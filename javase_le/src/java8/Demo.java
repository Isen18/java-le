package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * Demo
 *
 * @author Isen
 * @description
 * @date 2018/8/6 16:17
 **/
public class Demo {

    private int age = 10;

    public void print(){
        System.out.println("print");
    }

    public void print2(int a){
        System.out.println("print2");
    }

    private void fun(myI myI){
        System.out.println("fun");
        myI.print(10);
    }

    @Test
    public void test(){
//        List<String> mobiles = new ArrayList<>();
//        mobiles.add("ok");
//        mobiles.add("ok1");
//        mobiles.add("ok2");
//        mobiles.add("ok3");
//        String[] mobs = mobiles.stream().toArray(String[]::new);
//        for(String s: mobs){
//
//            System.out.println(s);
//        }
        Demo demo = new Demo();
//        demo.fun(Demo::print);
//        demo.fun(demo::print);
//        demo.fun(Demo::print2);
        demo.fun(demo::print2);
    }

    public static void main(String[] args) {
//        Demo demo = new Demo();
//        demo.fun(Demo::print2);
        List<Integer> result = Arrays.asList(1, 3, 3, 2, 1);
        result.sort((a, b) -> a.compareTo(b));
        System.out.println(result);
        Set<Integer> set = new HashSet<>(result);
        System.out.println(set);
    }
}

interface myI{
    void print(int a);
}
