package 设计模式.adapter;

/**
 * @author Isen
 * @date 2018/12/21 16:06
 * @since 1.0
 */
public interface Targetable {

    /**
     * 与原类中的方法相同
     */
    void method1();

    /**
     * 新类的方法
     */
    void method2();
}
