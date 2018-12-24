package 设计模式.adapter;

/**
 * 接口的适配器模式
 *
 * @author Isen
 * @date 2018/12/21 16:14
 * @since 1.0
 */
public abstract class AbstractSourceable implements Sourceable {

    @Override
    public void method1() {
        System.out.println("AbstractSourceable 默认实现方法 method1");
    }

    @Override
    public void method2() {
        System.out.println("AbstractSourceable 默认实现方法 method2");
    }
}
