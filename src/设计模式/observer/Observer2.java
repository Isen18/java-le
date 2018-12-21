package 设计模式.observer;

/**
 * @author Isen
 * @date 2018/12/21 17:56
 * @since 1.0
 */
public class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
