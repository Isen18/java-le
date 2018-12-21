package 设计模式.decorator;

/**
 * @author Isen
 * @date 2018/12/21 16:36
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
