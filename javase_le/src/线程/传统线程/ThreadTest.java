package 线程.传统线程;

class MyThread extends Thread {
	private int ticket = 10;

	@Override
	public void run() {
		while(ticket > 0){
			System.out.println(this.getName() + " 卖票:" + ticket--);
		}
	}
}

class MyRunnable implements Runnable{
	private int ticket = 10;

	@Override
	public void run() {
		while(ticket > 0){
		    //没有加锁，多个线程共同拥有ticket时，会有并发问题
			System.out.println(Thread.currentThread().getName() + " 卖票:" + ticket--);
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		// 启动3个线程t1、t2、t3，每个线程各卖10张票
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		Thread t3 = new Thread(new MyRunnable());
		t1.start();
		t2.start();
		t3.start();

		// 启动3个线程t4、t5、t6，三个线程共卖10张票
		MyRunnable myRunnable = new MyRunnable();
		Thread t4 = new Thread(myRunnable);
		Thread t5 = new Thread(myRunnable);
		Thread t6 = new Thread(myRunnable);
		t4.start();
		t5.start();
		t6.start();
	}
}

//public class ThreadTest {
//	public static void main(String[] args) {
//		// 启动3个线程t1,t2,t3；每个线程各卖10张票！
//		MyThread t1 = new MyThread();
//		MyThread t2 = new MyThread();
//		MyThread t3 = new MyThread();
//		t1.start();
//		t2.start();
//		t3.start();
//	}
//}
