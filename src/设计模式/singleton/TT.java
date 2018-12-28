package 设计模式.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

/**
 * @author Isen
 * @date 2018/12/25 23:04
 * @since 1.0
 */
public class TT {

    /**
     * 序列化攻击测试
     */
    @Test
    public void testSerializationAttack() throws IOException, ClassNotFoundException {
        System.out.println("序列化攻击测试");
        Singleton singleton = Singleton.getInstance();
        System.out.println("singleton " + singleton.hashCode());
        System.out.println("singleton " + serAndDeSer(singleton).hashCode());

        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println("singleton2 " + singleton2.hashCode());
        System.out.println("singleton2 " + serAndDeSer(singleton2).hashCode());

        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println("singleton3 " + singleton3.hashCode());
        System.out.println("singleton3 " + serAndDeSer(singleton3).hashCode());

        Singleton4 singleton4 = Singleton4.INSTANCE;
        System.out.println("singleton4 " + singleton4.hashCode());
        System.out.println("singleton4 " + serAndDeSer(singleton4).hashCode());

    }

    /**
     * 特权反射攻击测试
     */
    @Test
    public void testPrivilegeAttack()
            throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println("特权反射攻击测试");
        Singleton singleton = Singleton.getInstance();
        System.out.println("singleton " + singleton.hashCode());
        System.out.println("singleton " + newByReflect(singleton).hashCode());

        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println("singleton2 " + singleton2.hashCode());
        System.out.println("singleton2 " + newByReflect(singleton2).hashCode());

        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println("singleton3 " + singleton3.hashCode());
        System.out.println("singleton3 " + newByReflect(singleton3).hashCode());

        Singleton4 singleton4 = Singleton4.INSTANCE;
        System.out.println("singleton4 " + singleton4.hashCode());
        //抛异常(java.lang.NoSuchMethodException)，无法通过反射生成
        System.out.println("singleton4 " + newByReflect(singleton4).hashCode());

    }

    private Object serAndDeSer(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(object);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    private Object newByReflect(Object object)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //方法1
        Constructor constructor = object.getClass().getDeclaredConstructor();
        AccessibleObject.setAccessible(new AccessibleObject[]{constructor}, true);
        return constructor.newInstance();

        //方法2 调用私有构造函数
//        Constructor constructor = object.getClass().getDeclaredConstructor();
//        constructor.setAccessible(true);
//        return constructor.newInstance();
    }
}
