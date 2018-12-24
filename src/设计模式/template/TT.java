package 设计模式.template;

/**
 * @author Isen
 * @date 2018/12/21 17:48
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
