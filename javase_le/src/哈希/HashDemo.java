package 哈希;

import java.awt.print.Printable;

public class HashDemo {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T1 t12 = new T1();
		T2 t2 = new T2();
		System.out.println(t1==t12);
		System.out.println(t1);
	}
}
class T1{
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
class T2{
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 2;
	}
}
