package 线程.juc;

public class Demo2 {
	static Object object1 = new Object();
	static Object object2 = new Object();
	
	static void testDeadLock(){
		new Thread(){
			public void run() {
				synchronized (object1) {
					try {
						Thread.sleep(1000);
						System.out.println("占有object1，请求object2");
						synchronized(object2){
							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		new Thread(){
			public void run() {
				synchronized (object2) {
					try {
						Thread.sleep(1000);
						System.out.println("占有object1，请求object2");
						synchronized(object1){
							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	
	static void testDeadIterate(){
		while(true){
			try {
				Thread.sleep(100);
				System.out.println("死循环");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
//		testDeadLock();
		testDeadIterate();
	}
}

