package 线程;

import java.util.concurrent.locks.LockSupport;

/**
 * 	LockSupport是用来创建锁和其他同步类的基本线程阻塞原语。 
	LockSupport中的park() 和 unpark() 的作用分别是阻塞线程和解除阻塞线程，而且park()和unpark()不会遇到“Thread.suspend 和 Thread.resume所可能引发的死锁”问题。
	 因为park() 和 unpark()有许可的存在；调用 park() 的线程和另一个试图将其 unpark() 的线程之间的竞争将保持活性。
 */
/**
 * 	 // 返回提供给最近一次尚未解除阻塞的 park 方法调用的 blocker 对象，如果该调用不受阻塞，则返回 null。
	 static Object getBlocker(Thread t)
	 // 为了线程调度，禁用当前线程，除非许可可用。
	 static void park()
	 // 为了线程调度，在许可可用之前禁用当前线程。
	 static void park(Object blocker)
	 // 为了线程调度禁用当前线程，最多等待指定的等待时间，除非许可可用。
	 static void parkNanos(long nanos)
	 // 为了线程调度，在许可可用前禁用当前线程，并最多等待指定的等待时间。
	 static void parkNanos(Object blocker, long nanos)
	 // 为了线程调度，在指定的时限前禁用当前线程，除非许可可用。
	 static void parkUntil(long deadline)
	 // 为了线程调度，在指定的时限前禁用当前线程，除非许可可用。
	 static void parkUntil(Object blocker, long deadline)
	 // 如果给定线程的许可尚不可用，则使其可用。
	 static void unpark(Thread thread)
 */

/**
 * 
 * <p>
 * Title: LockSupportDemo
 * </p>
 * <p>
 * Description: park和wait的区别。wait让线程阻塞前，必须通过synchronized获取同步锁。
 * LockSupport 和 CAS一样是JUC很多控制机制的基础（但他们的底层其实都是在依赖Unsafe）
 * 
 * 函数中的blocker是一个和线程相关的对象，blocker用来做分析，debug用的
 * 带有blocker的park是debug版本用于调试
 * 
 * block当前线程，是否真的block了取决于permit是否available
 * permit相当于1,0的开关， 默认是0， 
 * 调一次unpark，permit就变成1了,
 * 调一次park会消费这个permit，permit有变成成0了（park立即返回）,
 * 再次调用park会变成block（因为没有1可以拿了，会等在这，直到有1），这时调用unpark会把1给回去(线程解锁返回)
 * 每个线程都有个相关的permit, permit最多一个,调用unpark多次也不会积累
 * </p>
 * 
 * @author zhang
 * @data 2016年12月7日
 * @time 下午9:03:05
 * @version 1.0
 * 
 */
//public class LockSupportDemo {
//
//	public static void main(String[] args) {
//
//		ThreadA ta = new ThreadA("ta");
//
//		synchronized (ta) { // 通过synchronized(ta)获取“对象ta的同步锁”
//			try {
//				System.out.println(Thread.currentThread().getName()
//						+ " start ta");
//				ta.start();
//
//				System.out.println(Thread.currentThread().getName() + " block");
//				// 主线程等待
//				ta.wait();
//
//				System.out.println(Thread.currentThread().getName()
//						+ " continue");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	static class ThreadA extends Thread {
//
//		public ThreadA(String name) {
//			super(name);
//		}
//
//		public void run() {
//			synchronized (this) { // 通过synchronized(this)获取“当前对象的同步锁”
//				System.out.println(Thread.currentThread().getName()
//						+ " wakup others");
//				notify(); // 唤醒“当前对象上的等待线程”
//			}
//		}
//	}
//}

public class LockSupportDemo {
	private static Thread mainThread;

	public static void main(String[] args) {

		ThreadA ta = new ThreadA("ta");
		// 获取主线程
		mainThread = Thread.currentThread();

		System.out.println(Thread.currentThread().getName() + " start ta");
		ta.start();

		System.out.println(Thread.currentThread().getName() + " block");
		// 主线程阻塞
		LockSupport.park(mainThread);//=LockSupport.park();
//		LockSupport.park();

		System.out.println(Thread.currentThread().getName() + " continue");
	}

	static class ThreadA extends Thread {

		public ThreadA(String name) {
			super(name);
		}

		public void run() {
			System.out.println(Thread.currentThread().getName()
					+ " wakup others");
			// 唤醒“主线程”
			LockSupport.unpark(mainThread);
		}
	}
}

