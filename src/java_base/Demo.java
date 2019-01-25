package java_base;


public class Demo {
	private int age =10;

	private void print(Demo demo){
		System.out.println(demo.age);
	}

	private void print(Integer a){
	    System.out.println(a);
	    a = 1000;
    }

	public static void main(String[] args) {
		Demo demo = new Demo();
		Demo demo2 = new Demo();
		demo.age = 12;

		demo2.print(demo);

        Integer a = 2000;
		demo.print(a);
		System.out.println(a);
	}
}
