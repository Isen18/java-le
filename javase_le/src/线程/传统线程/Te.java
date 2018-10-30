package 线程.传统线程;

public class Te {
	
	public static void main(String[] args) {
		MyTh myTh = new MyTh();
		Thread thread = new Thread(myTh);
		thread.start();
		try {
			System.out.println("main线程尝试获取MyTh锁");
			MyTh.class.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyTh implements Runnable{

	@Override
	public void run() {
		synchronized (MyTh.class) {
			System.out.println(Thread.currentThread().getName() + "获得了MyTh的类对象锁并且不释放锁");
			while(true);
		}
	}
	
}