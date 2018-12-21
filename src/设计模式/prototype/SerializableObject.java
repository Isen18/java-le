package 设计模式.prototype;

import java.io.Serializable;

/**
 * @author Isen
 * @date 2018/12/21 15:55
 * @since 1.0
 */
public class SerializableObject implements Serializable {

    private static final long serialVersionUID = -2555890290220519055L;
    private int a = 10;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "SerializableObject{" +
                "a=" + a +
                '}';
    }
}
