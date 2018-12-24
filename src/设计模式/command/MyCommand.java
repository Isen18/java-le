package 设计模式.command;

/**
 * @author Isen
 * @date 2018/12/24 9:50
 * @since 1.0
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
