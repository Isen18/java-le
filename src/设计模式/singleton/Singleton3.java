package 设计模式.singleton;

/**
 * 懒汉模式(增强)
 *
 * @author Isen
 * @date 2018/12/21 11:12
 * @since 1.0
 */
public class Singleton3 {

    /**
     * 私有化构造函数，防止被实例化(无法完全防止)
     */
    private Singleton3() {}

    /**
     * 返回单例，发现没有初始化，进行初始化
     */
    public static Singleton3 getInstance() {
        //jvm对SingletonFactory进行加载(线程互斥)，从而对instance进行初始化
        return SingletonFactory.instance;
    }

    /**
     * 内部类来维护单例
     */
    private static class SingletonFactory{
        private static Singleton3 instance = new Singleton3();
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return getInstance();
    }
}
