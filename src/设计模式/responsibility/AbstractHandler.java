package 设计模式.responsibility;

/**
 * @author Isen
 * @date 2018/12/24 9:42
 * @since 1.0
 */
public abstract class AbstractHandler {
    private Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
