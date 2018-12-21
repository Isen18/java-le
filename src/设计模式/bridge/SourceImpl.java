package 设计模式.bridge;

/**
 * @author Isen
 * @date 2018/12/21 16:55
 * @since 1.0
 */
public class SourceImpl implements Sourceable {

    @Override
    public void method() {
        System.out.println("SourceImpl 实现了方法 method");
    }
}
