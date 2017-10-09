package 线程;

import java.util.concurrent.locks.LockSupport;

public class Test implements Runnable{

	public synchronized void get(){
		System.out.println(Thread.currentThread().getId());
		set();
	}

	public synchronized void set(){
		System.out.println(Thread.currentThread().getId());
	}

	@Override
	public void run() {
		get();
	}
	public static void main(String[] args) {
		Test ss=new Test();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		
//		LockSupport
	}
}

