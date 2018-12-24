package 设计模式.responsibility;

/**
 * @author Isen
 * @date 2018/12/24 9:43
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");

        h1.setNextHandler(h2);
        h2.setNextHandler(h3);

        h1.operator();
    }
}
