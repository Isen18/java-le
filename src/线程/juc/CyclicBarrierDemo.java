package 线程.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 	CyclicBarrier是一个同步辅助类，允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。
	注意比较CountDownLatch和CyclicBarrier：
	(01) CountDownLatch的作用是允许1或N个线程等待其他线程完成执行；而CyclicBarrier则是允许N个线程相互等待。
	(02) CountDownLatch的计数器无法被重置；CyclicBarrier的计数器可以被重置后使用，因此它被称为是循环的barrier。
 */
/**
 * 
 *<p>Title: CyclicBarrierDemo</p>
 *<p>Description: </p>
 * @author zhyi
 * @data 2016年12月8日
 * @time 下午7:18:36
 * @version 1.0
 *
 */
public class CyclicBarrierDemo {

    private static int SIZE = 5;
    private static CyclicBarrier cb;
    public static void main(String[] args) {
//        cb = new CyclicBarrier(SIZE);
    	
    	cb = new CyclicBarrier(SIZE, new Runnable () {
            public void run() {
            	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("CyclicBarrier's parties is: "+ cb.getParties());
            }
        });
    	
        // 新建5个任务
        for(int i=0; i<SIZE; i++)
            new InnerThread().start();
    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");

                // 将cb的参与者数量加1
                cb.await();

                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}