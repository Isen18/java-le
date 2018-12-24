package 设计模式.command;

/**
 * @author Isen
 * @date 2018/12/24 9:50
 * @since 1.0
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.exe();
    }
}
