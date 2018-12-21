package 设计模式.observer;

/**
 * @author Isen
 * @date 2018/12/21 17:59
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
