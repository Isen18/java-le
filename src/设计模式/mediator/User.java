package 设计模式.mediator;

/**
 * @author Isen
 * @date 2018/12/24 15:18
 * @since 1.0
 */
public abstract class User {
    private Mediator mediator;

    public Mediator getMediator(){
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}
