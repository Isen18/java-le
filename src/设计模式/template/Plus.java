package 设计模式.template;

/**
 * @author Isen
 * @date 2018/12/21 17:47
 * @since 1.0
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
