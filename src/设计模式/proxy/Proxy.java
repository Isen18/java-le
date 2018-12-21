package 设计模式.proxy;

/**
 * @author Isen
 * @date 2018/12/21 16:45
 * @since 1.0
 */
public class Proxy implements Sourceable {
    private Source source;

    public Proxy(){
        this.source = new Source();
    }

    @Override
    public void method() {
        System.out.println("before proxy");
        source.method();
        System.out.println("after proxy");
    }
}
