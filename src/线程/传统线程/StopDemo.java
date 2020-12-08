package 线程.传统线程;

/**
 * @author Isen
 * @date 2019/2/16 18:10
 * @since 1.0
 */
public class StopDemo {
    public static void main(String [] args) throws Exception{
        TestObject testObject = new TestObject();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                try {
                    testObject.print("1", "2");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        Thread.sleep(1000);
        t1.stop();
        System.out.println("first : " + testObject.getFirst() + " " + "second : " + testObject.getSecond());
    }
}

class TestObject{
    private String first = "ja";
    private String second = "va";

    public synchronized void print(String first, String second) throws Exception{
        this.first = first;

        Thread.sleep(10000);

        this.second = second;
    }

    public synchronized String getFirst() {
        return first;
    }

    public synchronized void setFirst(String first) {
        this.first = first;
    }

    public synchronized String getSecond() {
        return second;
    }

    public synchronized void setSecond(String second) {
        this.second = second;
    }
}
