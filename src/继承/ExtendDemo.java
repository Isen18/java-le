package 继承;
public class ExtendDemo {
	public static void main(String[] args) {
//		new C().print();
//		((P)new C()).print(); //等价于上一句
//		((P)new C()).print4();
	}
}

class P{
	public P() {
		System.out.println("P constructor");
	}
	void print(){
		System.out.println("P print()");
		print2();
	}
	void print2(){
		System.out.println("P print2()");
	}
	void print4(){
		System.out.println("P print4()");
	}
}
class C extends P{
	public C() {
		System.out.println("C constructor");
	}
	@Override
	void print() {
		System.out.println("C print()");
		super.print();
	}
	@Override
	void print2() {
		System.out.println("C print2()");
//		super.print2();
	}
	void print3(){
		System.out.println("C pringt3()");
	}
}
