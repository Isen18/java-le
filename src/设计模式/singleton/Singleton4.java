package 设计模式.singleton;

/**
 * 枚举实现单例
 *
 * @author Isen
 * @date 2018/12/21 11:12
 * @since 1.0
 */
public enum Singleton4 {

    INSTANCE;

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return INSTANCE;
    }
}
