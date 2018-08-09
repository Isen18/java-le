package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * GenericUse
 *
 * @author Isen
 * @description
 * @date 2018/7/30 10:29
 **/
public class GenericUse {

    public static void main(String[] args) {
        //泛型类使用
        {
            //在实例化泛型类时，未指定泛型的具体类型，则泛型的默认类型为Object
            Persion persion = new Persion();
            persion.setT("helloWorld");
            //persion.getT() 返回Object类型  需要强制转换为String
            String str = (String) persion.getT();
        }
        {
            //在实例化泛型类时，指定了泛型的具体类型A，则所有出现泛型的地方均为类型A
            Persion<String> persion = new Persion<>();
            persion.setT("helloWorld");
            //persion.getT() 返回String类型
            System.out.println(persion.getT());
            {
                //泛型方法的具体化
                //persion.change(11)均返回Integer类型
                System.out.println(persion.change(11));
                //通用的泛型方法具体化
                System.out.println(persion.<Integer>change(11));
                //出错 指定类泛型具体类型为Integer的方法泛型类又用String进行具体化
//            System.out.println(persion.<Integer>change("12"));
            }
        }
    }
}

//泛型类
class Animal<T> {

}

//Cat继承Animal
//指定T为Short,Cat为具体类,不是泛型类
class Cat extends Animal<Short> {

}

//泛型类Persion继承Animal
//还未指定T,Persion是泛型类
class Persion<T> extends Animal<T> {

    private T t;
    List<T> list = new ArrayList<>();

    public T getT() {
        return this.t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //泛型方法
    public <E> E change(E e) {
        return e;
    }
}
