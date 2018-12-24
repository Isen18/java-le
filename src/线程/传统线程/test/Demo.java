package 线程.传统线程.test;

/**
 * @author Isen
 * @date 2018/12/19 22:44
 * @since 1.0
 */
public class Demo {

    public void test1() {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(this.getName());
            }
        };

        Thread t2 = new Thread(t);
        t2.setName("A");
        t2.start();
    }

    public void main() {
        MyThread t = new MyThread();
        Thread t2 = new Thread(t);
        t2.start();
        t.ter();
    }
}


class MyThread implements Runnable{
    private boolean stop = false;

    @Override
    public void run() {
        while (!stop){
            System.out.println("ok");
        }

        System.out.println("停止线程了");
    }

    public void ter(){
        stop = true;
    }
}