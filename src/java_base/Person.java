package java_base;

import java.io.*;

public class Person {
	public static void main(String[] args) {
		try {
			PrintStream printStream=System.out;
			File file=new File(new File("").getCanonicalPath()+"/he");
			System.setOut(new PrintStream(file));
			System.out.println("你好啊22");
			File file2=new File(new File("").getCanonicalPath()+"/he2");
			System.setOut(new PrintStream(file2));
			System.out.println("你好啊22");
			System.setOut(printStream);
			System.out.println("hee");
//			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("helo");
//		new Teacher();
	}
	int age=10;
	Person(){
		
	}
	
}

class Teacher extends Person{
	public Teacher() {
		System.out.println(super.age);
	}
}