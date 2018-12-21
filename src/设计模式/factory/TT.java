package 设计模式.factory;

import org.junit.Test;

/**
 * @author Isen
 * @date 2018/12/21 10:55
 * @since 1.0
 */
public class TT {

    @Test
    public void testSendFactory(){
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce("sms");
        sender.send();

        Sender sender2 = sendFactory.produce("mail");
        sender2.send();
    }

    @Test
    public void testSendFactory2(){
        SendFactory2 sendFactory = new SendFactory2();
        Sender sender = sendFactory.produceSmsSender();
        sender.send();

        Sender sender2 = sendFactory.produceMailSender();
        sender2.send();
    }

    @Test
    public void testSendFactory3(){
        Sender sender = SendFactory3.produceSmsSender();
        sender.send();

        Sender sender2 = SendFactory3.produceMailSender();
        sender2.send();
    }

    @Test
    public void testFactory(){
        Factory factory = new SendMailFactory();
        Sender sender = factory.produce();
        sender.send();

        Factory factory2 = new SendSmsFactory();
        Sender sender2 = factory2.produce();
        sender2.send();
    }
}
