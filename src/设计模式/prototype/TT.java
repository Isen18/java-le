package 设计模式.prototype;

import java.io.IOException;

/**
 * @author Isen
 * @date 2018/12/21 15:58
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Prototype prototype = new Prototype();
        Prototype prototype2 = prototype.deepClone();
        prototype.getSerializableObject().setA(1111);

        System.out.println(prototype);
        System.out.println(prototype2);
    }
}
