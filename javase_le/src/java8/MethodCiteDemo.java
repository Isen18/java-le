package java8;

import java.util.Arrays;
import java.util.List;

/**
 * MethodCiteDemo
 *
 * @description:
 * @author: Isen
 * @date: 2018/7/25 0:43
 **/
public class MethodCiteDemo {

    public static void main(String args[]) {
        //构造器引用：它的语法是Class::new，或者更一般的Class<T>::new
        //等价于lambda表达式：() -> {return new Class();}
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        //静态方法引用：它的语法是Class::static_method
        cars.forEach(Car::collide);

        //特定类的任意对象的方法引用：它的语法是Class::method
        //等价于lambda表达式: (Class clazz, method的参数列表) -> clazz.method(method的参数列表);
        cars.forEach(Car::repair);

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        //等价于上面
        Arrays.sort(stringArray, (a, b) -> a.compareToIgnoreCase(b));

        //特定对象的方法引用：它的语法是instance::method
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}


@FunctionalInterface
interface Supplier<T> {

    T get();
}

class Car {

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}