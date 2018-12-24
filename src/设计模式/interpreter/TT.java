package 设计模式.interpreter;

/**
 * @author Isen
 * @date 2018/12/24 15:27
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {

        // 计算9+2-8的值
        int result = new Minus().interpret((new Context(new Plus().interpret(new Context(9, 2)), 8)));
        System.out.println(result);
    }
}
