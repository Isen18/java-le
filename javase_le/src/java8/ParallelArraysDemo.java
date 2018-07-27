package java8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * java8.ParallelArraysDemo
 *
 * @author Isen
 * @description
 * @date 2018/7/26 11:32
 **/
public class ParallelArraysDemo {

    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
    }
}
