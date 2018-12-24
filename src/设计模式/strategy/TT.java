package 设计模式.strategy;

/**
 * @author Isen
 * @date 2018/12/21 17:42
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
