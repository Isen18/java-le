package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Isen
 * @date 2018/10/30 10:33
 * @since 1.0
 */
public class StreamDemo2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 1, 5);

        List<Integer> list2 = list.stream().sorted().collect(Collectors.toList());

        System.out.println(list);

        System.out.println(list2);

        list.sort((a, b) -> {
            if(a > b){
                return 1;
            }
            if(a < b){
                return -1;
            }
            return 0;
        });

        System.out.println(list);
    }
}
