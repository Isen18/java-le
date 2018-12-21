package 设计模式.factory;

/**
 * @author Isen
 * @date 2018/12/21 12:41
 * @since 1.0
 */
public class SendMailFactory implements Factory {

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
