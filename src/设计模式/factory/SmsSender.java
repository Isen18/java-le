package 设计模式.factory;

/**
 * @author Isen
 * @date 2018/12/21 10:50
 * @since 1.0
 */
    public class SmsSender implements Sender {

        @Override
        public void send() {
            System.out.println("send a sms.");
        }
    }
