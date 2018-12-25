package 线程;

/**
 * @author Isen
 * @date 2018/12/24 22:00
 * @since 1.0
 */
public class InheritableThreadLocalTest {

    public static void main(String[] args) {
        InheritableThreadLocal<Integer> integerInheritableThreadLocal = new InheritableThreadLocal(){
            @Override
            protected Object childValue(Object parentValue) {
                return "child " + parentValue;
            }
        };

        integerInheritableThreadLocal.set(11);
        System.out.println("main " + integerInheritableThreadLocal.get());
        new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + integerInheritableThreadLocal.get());
                    integerInheritableThreadLocal.set(123);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        integerInheritableThreadLocal.set(12);
        System.out.println("main " + integerInheritableThreadLocal.get());

    }
}
