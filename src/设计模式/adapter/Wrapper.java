package 设计模式.adapter;

/**
 * 对象的适配器模式
 *
 * @author Isen
 * @date 2018/12/21 16:09
 * @since 1.0
 */
public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
