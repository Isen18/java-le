package 设计模式.builder;

/**
 * @author Isen
 * @date 2018/12/21 15:37
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        Computer computer = Computer.builder().id(23).producer("com.isen18").build();

        System.out.println(computer);
    }
}
