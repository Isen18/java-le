package 设计模式.factory;

/**
 * 普通工厂模式
 *
 * @author Isen
 * @date 2018/12/21 10:51
 * @since 1.0
 */
public class SendFactory {

    public Sender produce(String type){
        if("sms".equals(type)){
            return new SmsSender();
        }else if("mail".equals(type)){
            return new MailSender();
        }else {
            throw new UnsupportedOperationException("type");
        }
    }
}
