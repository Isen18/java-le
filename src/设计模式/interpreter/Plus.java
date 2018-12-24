package 设计模式.interpreter;

/**
 * @author Isen
 * @date 2018/12/24 15:25
 * @since 1.0
 */
public class Plus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1() + context.getNum2();
    }
}
