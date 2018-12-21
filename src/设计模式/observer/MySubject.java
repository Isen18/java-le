package 设计模式.observer;

/**
 * @author Isen
 * @date 2018/12/21 17:58
 * @since 1.0
 */
public class MySubject extends AbstractSubject  {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
