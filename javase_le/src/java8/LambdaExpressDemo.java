package java8;

/**
 * java8.LambdaExpressDemo
 *
 * @description:
 * @author: Isen
 * @date: 2018/7/25 0:00
 **/
public class LambdaExpressDemo {


    public static void main(String args[]){

        LambdaExpressDemo lambdaExpressDemo = new LambdaExpressDemo();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambdaExpressDemo.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambdaExpressDemo.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambdaExpressDemo.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaExpressDemo.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        //外层的局部变量可以读取，不可以修改，带有final语义
        String str = "Hello";
        GreetingService greetingService = message -> System.out.println(str + message);
//        GreetingService greetingService = message -> str = "10";//修改str报错
        greetingService.sayMessage("world!");

        //Lambda表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
        String first = "";
//        GreetingService greetingService3 = first -> System.out.println(first); //声明first报错
    }


    interface MathOperation {
        int operation(int a, int b);

//        int test(); //当接口具有两个方法时，使用lambda表达式报错，必须只能有一个方法未实现
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}


