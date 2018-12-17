package java_base;
//deep copy  shallow copy
//一般步骤是（浅复制）：
//1. 被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常) 该接口为标记接口(不含任何方法)
//2. 覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象，（native为本地方法)
//为了达到真正的复制对象，而不是纯粹引用复制。我们需要将Address类可复制化，并且修改clone方法
class Address implements Cloneable {
	private String add;

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	
	@Override
	public Object clone() {
		Address addr = null;
		try{
			addr = (Address)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return addr;
	}
}

class Student implements Cloneable{
	private int number;

	private Address addr;
	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public Object clone() {
		Student stu = null;
		try{
			stu = (Student)super.clone();	//浅复制
			if(addr!=null){
				stu.addr = (Address)addr.clone();	//深度复制
			}
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return stu;
	}
}
public class Test {
	
	public static void main(String args[]) {
		
		Address addr = new Address();
		addr.setAdd("杭州市");
		Student stu1 = new Student();
		stu1.setNumber(123);
		stu1.setAddr(addr);
		
		Student stu2 = (Student)stu1.clone();
		
		System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
		System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());
		
		addr.setAdd("西湖区");
		
		System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
		System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());
	}
}