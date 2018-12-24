package 设计模式.visitor;

/**
 * @author Isen
 * @date 2018/12/24 15:11
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}
