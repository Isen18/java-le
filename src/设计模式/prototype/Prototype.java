package 设计模式.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Isen
 * @date 2018/12/21 15:54
 * @since 1.0
 */
public class Prototype implements Cloneable, Serializable {

    private int a = 12;
    private SerializableObject serializableObject = new SerializableObject();

    /**
     * 浅复制
     * clone 名称可以随意更改，只要保证调用了super.clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    /**
     * 深复制
     */
    public Prototype deepClone() throws IOException, ClassNotFoundException {

        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Prototype)ois.readObject();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public SerializableObject getSerializableObject() {
        return serializableObject;
    }

    public void setSerializableObject(SerializableObject serializableObject) {
        this.serializableObject = serializableObject;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "a=" + a +
                ", serializableObject=" + serializableObject +
                '}';
    }
}
