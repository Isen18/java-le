package 设计模式.interpreter;

/**
 * @author Isen
 * @date 2018/12/24 15:24
 * @since 1.0
 */
public interface Expression {

    int interpret(Context context);
}
