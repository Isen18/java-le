package 线程.传统线程;

/**
 * @author Isen
 * @date 2018/10/29 14:10
 * @since 1.0
 */
public class SychronizedDemo {

    private int age = 10;

    private static String name = "isen";

    private synchronized int getAge(){
        System.out.println(Thread.currentThread().getName() + " 成功获取 SychronizedDemo 的实例对象的对象锁，进入getAge()方法");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 退出getAge()方法");
        return age;
    }

    private synchronized void setAge(int age){
        System.out.println(Thread.currentThread().getName() + " 成功获取 SychronizedDemo 的实例对象的对象锁，进入setAge()方法");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.age = age;
        System.out.println(Thread.currentThread().getName() + " 退出setAge()方法");
    }

    private void printAge(){
        System.out.println(Thread.currentThread().getName() + " 进入printAge()方法");
        synchronized (this){
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 成功获取 SychronizedDemo 的实例对象的对象锁，进入synchronized (this)代码块");
            System.out.println("age = " + age);
        }
        System.out.println(Thread.currentThread().getName() + " 退出printAge()方法");
    }

    private synchronized static String getName(){
        System.out.println(Thread.currentThread().getName() + " 成功获取 SychronizedDemo 的类对象的对象锁，进入getName()方法");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 退出getName()方法");
        return name;
    }

    private synchronized static void setName(String name){
        System.out.println(Thread.currentThread().getName() + " 成功获取 SychronizedDemo 的类对象的对象锁，进入setName()方法");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SychronizedDemo.name = name;
        System.out.println(Thread.currentThread().getName() + " 退出setName()方法");
    }

    private static void printName(){
        System.out.println(Thread.currentThread().getName() + " 进入printName()方法");
        synchronized (SychronizedDemo.class){
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 成功获取 SychronizedDemo 的类对象的对象锁，进入printName()方法");
            System.out.println("name = " + name);
        }
        System.out.println(Thread.currentThread().getName() + " 退出printName()方法");
    }

    private void catAge(){
        System.out.println(Thread.currentThread().getName() + " 进入catAge()方法");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 退出catAge()方法");
    }

    private static void catName(){
        System.out.println(Thread.currentThread().getName() + " 进入catName()方法");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 退出catName()方法");
    }

    public static void main(String[] args) {
        SychronizedDemo sychronizedDemo = new SychronizedDemo();

        new Thread(){
            @Override
            public void run() {
                sychronizedDemo.getAge();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                sychronizedDemo.setAge(12);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                sychronizedDemo.printAge();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                SychronizedDemo.getName();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                SychronizedDemo.setName("lisi");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                SychronizedDemo.printName();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                sychronizedDemo.catAge();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                SychronizedDemo.catName();
            }
        }.start();
    }
}
