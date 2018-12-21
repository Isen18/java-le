package 设计模式.factory;

/**
 * @author Isen
 * @date 2018/12/21 12:43
 * @since 1.0
 */
public class SendSmsFactory implements Factory {

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
