package 线程.juc.util.blockingqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 消息体定义 实现Delayed接口就是实现两个方法即compareTo 和 getDelay最重要的就是getDelay方法，这个方法用来判断是否到期……
 *
 * @author Isen
 * @date 2018/11/16 10:59
 * @since 1.0
 */
public class Message implements Delayed {

    /**
     * 消息id
     */
    private int id;
    /**
     * 消息内容
     */
    private String body;
    /**
     * 延迟时长，这个是必须的属性因为要按照这个判断延时时长。
     */
    private long executeTime;

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public long getExcuteTime() {
        return executeTime;
    }

    public Message(int id, String body, long delayTime) {
        this.id = id;
        this.body = body;
        this.executeTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed delayed) {
        //到期的消息排序
        Message msg = (Message) delayed;
        return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1
                : (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //返回0或者负数表示到期
        return unit.convert(this.executeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }
}
