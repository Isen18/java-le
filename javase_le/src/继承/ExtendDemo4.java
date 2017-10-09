package 继承;

class Base{
	private void fun(){
		System.out.println("Base : private void fun()");
	}
	
	public Number fun2() {
		return 0;
	}
}

class SubBase extends Base{
	public void fun(){
		System.out.println("SubBase : public void fun()");
	}
	
	public Integer fun2() {
		return 1;
	}
}

interface in{
//	private static final int a = 10;
}

abstract class ab extends Base{
	abstract void fun();
}

class cl{
	int b = 1;
	void fun2(){
		System.out.println(new innerCl2().a);
	}
	
	void fun(final int b){
		
	 class innerCl{
//			static int a = 10;
			void print(){
//				System.out.println(a);
				System.out.println(b);
			}
		}
	}
	
//	xxx.setOncl(new OnlAd(){
//		void on(){
//			xxx.setText("ok");
//		}
//	});
	
	static class innerCl2{
		static int a = 10;
		void print(){
			System.out.println(a);
//			System.out.println(b);
		}
	}
}

public class ExtendDemo4 {
	public static void main(String[] args) {
		Base base = new SubBase();
//		base
		System.out.println(base.fun2());
	}
}
