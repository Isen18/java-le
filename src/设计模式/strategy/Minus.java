package 设计模式.strategy;

/**
 * @author Isen
 * @date 2018/12/21 17:40
 * @since 1.0
 */
public class Minus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\-");
        return arrayInt[0]+arrayInt[1];
    }
}
