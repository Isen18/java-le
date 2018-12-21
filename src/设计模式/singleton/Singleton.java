package 设计模式.singleton;

/**
 * 饿汉模式
 *
 * @author Isen
 * @date 2018/12/21 11:12
 * @since 1.0
 */
public class Singleton {

    /**
     * 提前初始化单例
     */
    private static Singleton instance = new Singleton();

    /**
     * 私有化构造函数，防止被实例化(无法完全防止)
     */
    private Singleton() {}

    /**
     * 返回单例
     */
    public static Singleton getInstance() {
        return instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return instance;
    }
}
