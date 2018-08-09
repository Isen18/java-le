package java8;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void test(){
        List<String> mobiles = new ArrayList<>();
        mobiles.add("ok");
        mobiles.add("ok1");
        mobiles.add("ok2");
        mobiles.add("ok3");
        String[] mobs = mobiles.stream().toArray(String[]::new);
        for(String s: mobs){

            System.out.println(s);
        }
    }
}
