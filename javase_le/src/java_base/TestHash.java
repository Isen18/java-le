package java_base;

public class TestHash {
	public static void main(String[] args) {
		P p=new P();
		System.out.println(p.hashCode());
//		p.setName("张三");
		System.out.println(p.hashCode());
		System.out.println(p.getName());
		System.out.println(p);
		
	}
}

class P{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
