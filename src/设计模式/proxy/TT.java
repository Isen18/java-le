package 设计模式.proxy;

/**
 * @author Isen
 * @date 2018/12/21 16:47
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
