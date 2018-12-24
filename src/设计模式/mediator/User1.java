package 设计模式.mediator;

/**
 * @author Isen
 * @date 2018/12/24 15:19
 * @since 1.0
 */
public class User1 extends User {
    public User1(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");
    }
}
