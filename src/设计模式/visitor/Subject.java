package 设计模式.visitor;

/**
 * @author Isen
 * @date 2018/12/24 15:09
 * @since 1.0
 */
public interface Subject {

    void accept(Visitor visitor);

    String getSubject();
}
