package 设计模式.command;

/**
 * @author Isen
 * @date 2018/12/24 9:50
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}
