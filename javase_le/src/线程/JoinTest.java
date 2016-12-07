package 线程;

//JoinTest.java的源码
public class JoinTest{ 
	
	
 public static void main(String[] args){ 
     try {
         ThreadA t1 = new ThreadA("t1"); // 新建“线程t1”

         t1.start();                     // 启动“线程t1”
         t1.join();                        // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
//         t1.myJoin(0);
         System.out.printf("%s finish\n", Thread.currentThread().getName()); 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 } 

 static class ThreadA extends Thread{

     public ThreadA(String name){ 
         super(name); 
     } 
     public void run(){ 
         System.out.printf("%s start\n", this.getName()); 

         for(int i=0;i<10;i++){
        	 try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }

         System.out.printf("%s finish\n", this.getName()); 
     }//执行完好像会默认调用notifyAll()
     public final synchronized void myJoin(long millis)
    		 throws InterruptedException {
        long base = System.currentTimeMillis();
        long now = 0;

        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (millis == 0) {
            while(isAlive()) {//用while而不用if原因防止其他线程调用notify或者notifyAll()，但是isAlive()还是true状态。
            				//这样会造成无法达到等待子线程完成，主线程才继续执行的目的
                wait(0);//释放了锁，并且在此处阻塞了
                System.out.println("hhhlo");
            }
        } else {
            while (isAlive()) {
                long delay = millis - now;
                if (delay <= 0) {
                    break;
                }
                wait(delay);
                now = System.currentTimeMillis() - base;
            }
        }
    }
 } 
}
