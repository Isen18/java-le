package 设计模式.singleton;

/**
 * 懒汉模式
 *
 * @author Isen
 * @date 2018/12/21 11:12
 * @since 1.0
 */
public class Singleton2 {

    /**
     * 初始化为nulL，懒加载
     */
    private static Singleton2 instance = null;

    /**
     * 私有化构造函数，防止被实例化(无法完全防止)
     */
    private Singleton2() {}

    /**
     * 返回单例，如果发现没有初始化，进行初始化
     */
    public static Singleton2 getInstance() {
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    //1、锁+双重检查，保证线程安全
                    //2、synchronized保证了可见性，所以其他线程会知道INSTANCE已经被new过了
                    //3、如果jvm new完Singleton2，并赋值给INSTANCE，但是还没对INSTANCE进行数据初始化就离开了synchronized，依旧会有问题(INSTANCE不是一个完整的)
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return instance;
    }
}
