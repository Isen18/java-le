package 设计模式.mediator;

/**
 * @author Isen
 * @date 2018/12/24 15:20
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
