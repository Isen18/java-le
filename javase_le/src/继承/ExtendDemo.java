package 继承;
public class ExtendDemo {
	public static void main(String[] args) {
//		new C().print();
//		((P)new C()).print();
//		((P)new C()).pr
		((P)new C()).print4();
	}
}

class P{
	void print(){
		System.out.println("print:I am P");
		print2();
	}
	void print2(){
		System.out.println("print2:I am P");
	}
	void print4(){
		System.out.println("print4:I am P");
	}
}
class C extends P{
	@Override
	void print() {
		// TODO Auto-generated method stub
		super.print();
	}
	@Override
	void print2() {
		// TODO Auto-generated method stub
//		super.print2();
		System.out.println("prnt2:I am C");
	}
	void print3(){
		
	}
}
