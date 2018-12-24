package 设计模式.factory;

/**
 * 静态工厂方法
 *
 * @author Isen
 * @date 2018/12/21 10:51
 * @since 1.0
 */
public class SendFactory3 {

    public static Sender produceMailSender(){
        return new MailSender();
    }

    public static Sender produceSmsSender(){
        return new SmsSender();
    }
}
