package 线程.定时任务;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Isen
 * @date 2018/12/25 21:24
 * @since 1.0
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            private int count = 0;

            @Override
            public void run() {
                System.out.println("timer begin" + new Date());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("timer count=" + count ++);
                System.out.println("timer end" + new Date());
            }
        }, new Date(System.currentTimeMillis() + 300), 100);


        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            private int count = 0;

            @Override
            public void run() {
                System.out.println("timer2 begin" + new Date());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("timer2 count=" + count ++);
                System.out.println("timer2 end" + new Date());
            }
        }, new Date(System.currentTimeMillis() + 300), 100);

    }
}
