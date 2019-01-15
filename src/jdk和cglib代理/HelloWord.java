package jdk和cglib代理;

/**
 * @author Isen
 * @date 2019/1/2 20:28
 * @since 1.0
 */
public class HelloWord {

    public void sayHello() {
        System.out.println("hello world !");
    }

    public int inc(int a){
        System.out.println("echo a=" + a);
        return a + 1;
    }

    public int fun(){
        throw new UnsupportedOperationException();
    }

    public static void main(String args[]) {
        HelloWord helloWord = new HelloWord();
        helloWord.sayHello();

        int ret = helloWord.inc(18);
        System.out.println("ret=" + ret);

        helloWord.fun();

    }
}
