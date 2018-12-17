package 继承;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExtendDemo3 {
	public static void main(String[] args) {//这个是标准main方法，是程序入口
		Cat cat = new Cat();
		Animal animal = cat;
		System.out.println(cat.word);//Cat : Hello World2
		System.out.println(animal.word);//Animal : Hello World
		//final 对于属性而言是声明常量，对于方法而言是拒绝覆盖
		cat.sleep(10);
		cat.call();
		
	}
	public static void main(String[] args,int a) {//main方法可以被重载
		System.out.println("hleo");
	}
}

class Animal{
	final String word = "Animal : Hello World";
	final void cry(){
		System.out.println("Animal : final void cry()");
	}
	static void laugh(){ 
		System.out.println("Animal : static void laugh()");
	}
	void sleep(){
		System.out.println("Animal : void sleep() : word = " + word);//此处word值永远是"Animal : Hello World"，即使是子类调用sleep
	}
	private void call(){
		System.out.println("Animal : private void call()");
	}
}

class Cat extends Animal{
	final String word = "Cat : Hello World2";
//	final void cry(){//不能覆盖，编译出错,不管有无final
//		System.out.println("Cat : final void cry()");
//	}
//	void laugh(){//不能覆盖，编译出错，不能静态、实例交叉覆盖
//		System.out.println("Cat : static void laugh()");
//	}
	void sleep(int time) throws NullPointerException{//既不是覆盖也不是重载
		System.out.println("Cat : void sleep(int time)");
		sleep();//调用父类sleep(),并且父类sleep()中的word调用的是父类的word
	}
	void call(){
		System.out.println("Cat : void call()");
	}
}

/**
 * 覆盖（重写、覆写）、重载条件、区别
 * 
 * 覆盖条件：
 * 
 * ①发生在父子类继承过程。
 * 
 * ②子类重新定义的方法与父类方法名称相同、参数相同（个数、类型、顺序相同）。方法的返回值、异常、访问修饰符是否相同不作为覆盖条件。
 * 
 * ③子类方法返回值类型、异常类型是跟父类相同或者是父类的子类。访问修饰符范围比父类大。
 * 
 * ④final方法不能被覆盖,无法继承的方法也不能被覆盖。
 * 
 * 注意：子类实例方法不能覆盖父类的静态方法；子类的静态方法也不能覆盖父类的实例方法(编译时报错)，总结为方法不能交叉覆盖。
 * 
 * 	          属性和静态方法可以被隐藏，不会被覆盖；实例方法可以被覆盖，不会被隐藏。以什么类访问被隐藏的成员就访问什么类的成员，父类访问父类的，子类访问子类的。
 * 
 * 	         若一个对象是子类实例，则对于被覆盖的方法，均只能访问子类的方法。动态绑定，受RTTI(run time type identification，运行时类型检查)约束
 * 
 * 重载条件：
 * 
 * ①发生在一个类内部，仅涉及一个类。
 * 
 * ②方法同名，参数不同（个数、类型、顺序不同）。方法的返回值、异常、访问修饰符是否相同不作为重载条件。
 * 
 * ③main方法可以被重载。
 * 
 */

/**
 * 其实实现类也可以看成接口的子类
 */
