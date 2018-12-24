package 设计模式.visitor;

/**
 * @author Isen
 * @date 2018/12/24 15:10
 * @since 1.0
 */
public class MyVisitor implements Visitor {

    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject：" + sub.getSubject());
    }
}
