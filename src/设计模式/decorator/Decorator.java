package 设计模式.decorator;

/**
 * @author Isen
 * @date 2018/12/21 16:34
 * @since 1.0
 */
public class Decorator implements Sourceable {
    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        sourceable.method();
        System.out.println("after decorator!");
    }
}
