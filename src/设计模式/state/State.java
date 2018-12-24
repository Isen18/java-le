package 设计模式.state;

/**
 * @author Isen
 * @date 2018/12/24 15:03
 * @since 1.0
 */
public class State {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1() {
        System.out.println("execute the first opt!");
    }

    public void method2() {
        System.out.println("execute the second opt!");
    }
}
