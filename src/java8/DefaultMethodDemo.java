package java8;

/**
 * java8.DefaultMethodDemo
 *
 * @description:
 * @author: Isen
 * @date: 2018/7/25 9:51
 **/
public class DefaultMethodDemo {

    public static void main(String[] args) {
        Vehicle vehicle = new MyCar();
        vehicle.print();
    }
}

class MyCar implements Vehicle, FourWheeler {

//    @Override
//    public void print() {
//        //覆盖接口中的默认方法
//        System.out.println("我是一辆汽车");
//    }

    @Override
    public void print(){
        //使用 super 来调用指定接口的默认方法
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
}

interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }

    // 静态方法
    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}