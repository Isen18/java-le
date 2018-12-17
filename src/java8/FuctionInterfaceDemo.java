package java8;

import java.util.Arrays;
import java.util.List;

/**
 * java8.FuctionInterfaceDemo
 *
 * @description: 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * @author: Isen
 * @date: 2018/7/25 9:40
 **/
public class FuctionInterfaceDemo {
    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // java8.Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 java8.Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

        System.out.println("输出所有数据:");

        // 传递参数 n
        eval(list, n->true);

        // java8.Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 java8.Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true

        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );

        // java8.Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 java8.Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true

        System.out.println("输出大于 3 的所有数字:");
        eval(list, n-> n > 3 );
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}

@FunctionalInterface //表明当前接口时函数式接口，推荐加上
interface Predicate<T>{
    boolean test(T t);

//    boolean test2(T t);//两个抽象方法，报错

    //默认方法和静态方法不会破坏函数式接口的定义

    default void print(){
        System.out.println("java8.Predicate");
    }

    static void print2(){
        System.out.println("java8.Predicate");
    }
}
