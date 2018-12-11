package 线程.juc;

import java.util.Date;

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
//		Test ss=new Test();
//		new Thread(ss).start();
//		new Thread(ss).start();
//		new Thread(ss).start();
		
//		LockSupport

//		System.out.println(new Date(0));
//
//		System.out.println(new Date(1540287741000L));
//		System.out.println(new Date(1540287716000L));
//		System.out.println(new Date(1536823735000L));
//		System.out.println(new Date(1536826125000L));
//		System.out.println(new Date(1536825681000L));
//		System.out.println(new Date(1536823431000L));

        try{
            int a = 10;
            int b = 0;
            int c = a / b;
        }finally {
            System.out.println("ok");
        }
	}
}

