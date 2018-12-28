package 设计模式.singleton;

import java.io.Serializable;

/**
 * 饿汉模式
 *
 * @author Isen
 * @date 2018/12/21 11:12
 * @since 1.0
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = 2633842665469091265L;

    /**
     * 是否已经实例化,一定要在构造函数前初始化
     */
    private static boolean hasInstanced = false;

    /**
     * 提前初始化单例
     */
    private static Singleton instance = new Singleton();

    /**
     * 私有化构造函数，防止被实例化
     */
    private Singleton() {
        if(hasInstanced){
           //实例化过，抛异常
           throw new UnsupportedOperationException("已经存在实例，不允许再次实例化");
        }
        hasInstanced = true;
    }

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
