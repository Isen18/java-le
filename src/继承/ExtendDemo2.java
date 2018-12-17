package 继承;
/**
 * 成员：变量+方法
 */
/**
 * 在每个类文件中最多有一个public类，当有public类的时候，类文件的名称必须和public类的名称相同，若不存在public，则类文件的名称可以为任意的名称
 * 在类内部，对于成员变量，如果在定义的时候没有进行显示的赋值初始化，则Java会保证类的每个成员变量都得到恰当的初始化：

　　1）对于  char、short、byte、int、long、float、double等基本数据类型的变量来说会默认初始化为0（boolean变量默认会被初始化为false）；

　　2）对于引用类型的变量，会默认初始化为null。

　　如果没有显示地定义构造器，则编译器会自动创建一个无参构造器，但是要记住一点，如果显示地定义了构造器，编译器就不会自动添加构造器。
 */

/**
 * 
　　当子类继承了继承父类的原则如下：

　　1）能够继承父类的public和protected成员；不能够继承父类的private成员；

　　2）对于父类的包访问权限成员，如果子类和父类在同一个包下，则子类能够继承；否则，子类不能够继承；

　　3）对于子类可以继承的父类成员，如果在子类中出现了同名称的成员，

	若该成员是变量时，则会发生隐藏现象，即子类的成员变量会屏蔽掉父类的同名成员变量；
	
	若该成员是方法是，则称为覆盖，即子类的成员方法会覆盖掉父类的同名成员方法。
	
	如果要在子类中访问父类中同名成员，通过super进行访问。

**（都继承了，其实只是访问不到而已，子类对象中还是有父类的成员）
 */

/**
 * super主要有两种用法：

　　1）super.成员变量/super.成员方法;

　　2）super(parameter1,parameter2....);//语句要作为放在构造器中的第一条语句。
 */

/**
 * 构造器说明：
 * 
 * 构造器不存在继承之说，若一个类没有任何用户定义的构造器，则编译器会默认给该类生成一个无参的构造器；若类存在用户定义的构造器，则编译器不会提供默认的构造器。
 * 
 * 若一个类继承一个没有无参的构造器的类，则必须在该类的构造器中通过super调用父类的构造器。
 */
/**
 * 
 *<p>Title: ExtendDemo2</p>
 *<p>Description: </p>
 * @author zhang
 * @data 2016年12月4日
 * @time 下午9:38:38
 * @version 1.0
 *
 */
public class ExtendDemo2 {
	public static void main(String[] args) {
		Man man = new Man();
		/**
		 * 上述语句执行结果如下：
		 * 	
		 	Person: static int getAge()
			Person: static语句块
			Man: static语句块
			Man: static int getAge()
			Man: String getName() //由于是实例方法，所以该方法绑定的对象是实际对象，它的类型是Man
			Person: 实例语句块
			Pserson: constructor : Person()
			Man: 实例语句块
			Man: String getName()
			Man: constructor : Man()
		 *
		 * 结论：
		 * 
		 * 类实例化时，若首先检查该类的父类是否加载了，若父类未在加载，则加载父类，这个递归过程向上传递至Object,所以会先加载Object(若未加载)，再逐步向下加载各类，直至要实例化的那个类为止。
		 * 
		 * 加载类时，按照代码顺序依次执行类X的静态成员变量初始化、静态语句，然后对子类Y实行同样过程。父类优先，子类次之。
		 * 
		 * 所有类加载完，则按照代码顺依次执行类X的实例变量初始化、实例语句块，然后执行构造函数，然后对子类Y实行同样过程。父类优先，子类次之。
		 */
		//以下语句执行结果在最后条语句最后边
		man.say();//Man: void say() and name = null age = 11
		man.tell();//等价于Man.tell(); Man: static void tell() and age = 11
		Person person = man;
		person.say();//等价于man.say(); Man: void say() and name = null age = 11
		person.tell();//等价于Person.tell(); Person:static void tell() and age = 10
		System.out.println(man.name);//Man
		System.out.println(person.name);//Man
		System.out.println(man.name2);//Man : name2
		System.out.println(person.name2);//Person : name2
		System.out.println(man.age);//11
		System.out.println(person.age);//等价于Person.age; 10
		/**
		 * 根据上述执行情况可以得出如下结论：
		 * 
		 * 在访问类实例方法时，会发生动态绑定，而在访问类的静态变量和静态方法以及实例变量时，则不会发生动态绑定。
		 * 
		 * 当然了由于final方法是无法继承的，所以没有覆盖之说，覆盖和隐藏均要在能够继承的情况下才有意义。
		 * 
		 * 以实际类（子类）身份访问对象时，所有同名（跟父类同名，而不是子类中同名（方法重载））成员以实际类中定义的优先，实际类中没有同名的。
		 * 
		 * 以实际类（子类）的父类身份访问对象时，所有可访问的成员只能是已经在父类中定义的成员，并且对于对于与子类同名的实例方法访问，发生动态绑定，访问的是子类实例方法。
		 * 
		 * 覆盖：发生在父子类的同名、同参的实例方法中，隐藏发生在父子同名、同参的静态方法或者同名变量（静态+实例）中。
		 */
	}
}

class Person{
	String name = getName();
	
	String name2 = "Person : name2";
	
	static int age = getAge();
	
	{
		System.out.println("Person: 实例语句块");
	}
	
	static{
		System.out.println("Person: static语句块");
	}
	
	public Person() {
		System.out.println("Pserson: constructor : Person()");
	}
	
	
	void say(){
		System.out.println("Person:void say() and name = " + name + " age = " + age);
	}
	
	static void tell(){
		System.out.println("Person:static void tell() and age = " + age);
	}
	
	String getName(){
		System.out.println("Person: String getName()");
//		return name;//其实此时name还没初始化，为null
		return "Person";
	}
	
	static int getAge(){
		System.out.println("Person: static int getAge()");
		return 10;
	}
}

class Man extends Person{
	
	
	{
		System.out.println("Man: 实例语句块");
	}
	
	String name = getName();
	
	String name2 = "Man : name2";
	
	static{
		System.out.println("Man: static语句块");
	}
	
	static int age = getAge();
	
	public Man() {
		System.out.println("Man: constructor : Man()");
	}
	
	void say(){
		System.out.println("Man: void say() and name = " + name + " age = " + age);
	}
	
	static void tell(){
		System.out.println("Man: static void tell() and age = " + age);
	}
	
	String getName(){
		System.out.println("Man: String getName()");
//		return name;
		return "Man";
	}
	
	static int getAge(){
		System.out.println("Man: static int getAge()");
		return 11;
	}
}

