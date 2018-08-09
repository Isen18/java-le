package 泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import org.junit.Test;

/**
 * Demo
 *
 * @author Isen
 * @description
 * @date 2018/7/30 10:21
 **/
public class Demo {

    @Test
    public void useGeneric() {
        //未使用泛型
        List list = new ArrayList();
        list.add(1);
        //加入类型不一致
        list.add("one");
        for (int i = 0; i < list.size(); i++) {
            //出现ClassCastException
            int num = (int) list.get(i);
        }
    }

    @Test
    public void notUseGeneric() {
        //使用泛型,保证了集合使用的安全性
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //不能加入其它类型
//        list.add("one");
        for (int i = 0; i < list.size(); i++) {
            //不会出现ClassCastException
            int num = list.get(i);
        }
    }


    @Test
    public void tsetRawType(){
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, new Integer(18));
        String s = strings.get(0);

    }

    public void unsafeAdd(List list, Object object){
        list.add(object);
    }

//    public void unsafeAdd(List<Object> list, Object object){
//        list.add(object);
//    }

    @Test
    public void teset2(){
//        List.class
//        String[].class
//        int.class
//        List<String>.class
//        List<?>.class
        Set<Integer> o = new HashSet();
        if(o instanceof Set){
            Set<?> m = (Set<?>)o;
        }

        if(o instanceof Set<?>){
            Set<?> m = (Set<?>)o;
        }

//        if(o instanceof Set<Integer>){//非法
//            Set<?> m = (Set<?>)o;
//        }

        Object[] objects = new Long[1];
        objects[0] = "ok?";

//        List<Object> list = new ArrayList<Long>();
//        list.add("ok?");

//        List<E>[]

//        List<String> [] stringLists = new ArrayList<String>[1];
//        List<Integer> intList = Arrays.asList(43);
//        Object[] objects = stringLists;
//        objects[0] = intList;
//        String s = stringLists[0].get(0);
//        Stack
//        String
    }
}


