package 设计模式.observer;

/**
 * @author Isen
 * @date 2018/12/21 17:56
 * @since 1.0
 */
public interface Subject {

    /**
     * 增加观察者
     */
    void add(Observer observer);

    /**
     * 删除观察者
     */
    void del(Observer observer);

    /**
     * 通知所有的观察者
     */
    void notifyObservers();

    /**
     * 自身的操作
     */
    void operation();
}
