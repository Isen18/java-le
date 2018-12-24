package 设计模式.proxy;

/**
 * @author Isen
 * @date 2018/12/21 16:45
 * @since 1.0
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
