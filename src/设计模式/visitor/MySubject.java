package 设计模式.visitor;

/**
 * @author Isen
 * @date 2018/12/24 15:10
 * @since 1.0
 */
public class MySubject implements Subject {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
