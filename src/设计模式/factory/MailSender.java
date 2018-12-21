package 设计模式.factory;

/**
 * @author Isen
 * @date 2018/12/21 10:51
 * @since 1.0
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("sned a mail.");
    }
}
