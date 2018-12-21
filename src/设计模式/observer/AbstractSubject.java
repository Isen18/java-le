package 设计模式.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Isen
 * @date 2018/12/21 17:57
 * @since 1.0
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<>();
    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }
}
