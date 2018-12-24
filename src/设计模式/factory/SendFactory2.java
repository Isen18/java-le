package 设计模式.factory;

/**
 * 多个工厂方法模式
 *
 * @author Isen
 * @date 2018/12/21 10:51
 * @since 1.0
 */
public class SendFactory2 {

    public Sender produceMailSender(){
        return new MailSender();
    }

    public Sender produceSmsSender(){
        return new SmsSender();
    }
}
