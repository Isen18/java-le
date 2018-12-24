package 设计模式.bridge;

/**
 * @author Isen
 * @date 2018/12/21 16:57
 * @since 1.0
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
