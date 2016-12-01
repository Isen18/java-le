package 枚举;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * 
 *<p>Title: EnumDemo</p>
 *<p>Description: 枚举的基本使用。枚举限定了常量集合的边界，避免了以前使用接口中的常量时需要边界检查以及相关边界检查处理程序</p>
 * @author zhyi
 * @data 2016年12月1日
 * @time 上午11:21:27
 * @version 1.0
 *
 */
public class EnumDemo {
    /**
     * 最简单的枚举示例
     * */
    public enum SimpleEnum {//枚举类的访问修饰符只能是public,并且不能是abstract
    	/**
    	 * UP、DOWN本身就是SimpleEnum的一个实例对象,并且是常量
    	 */
        UP, DOWN //可以加;
    }
     
    /**
     * 带有属性和方法的枚举示例
     * 注意：枚举本身也是类，可以象一般的类一样为它添加静态或者非静态的属性或方法
     *        但是枚举列表必须写在最前面，否则编译出错。比如本例中的UP，DOWN
     * */
    public enum EnumWithFuncAndAttr {
        UP, DOWN;
        private static final String description = "这个是一个有方法和属性的枚举示例";
 
        public String getDescription() {
            return description;
        }
    }
     
    /**
     * 带有构造函数的枚举示例
     * 注意：枚举可以有构造方法，通过括号赋值。如果不赋值，那么就不能编写构造方法，否则出错。
     * 构造方法只能是private的或者默认(private)的。而不能是public以及protected。这样做可以保证客户代码没有办法新建一个enum的实例
     * */
    public enum EnumWithConstructor{
    	UP("hello"),DOWN("java");
        private final String value;//可以将value作为key，然后读取国际化文件中的value，实现国际化
        String getValue(){
            return value;
        }
        EnumWithConstructor(String value){
            this.value=value;
        }
    }
    /**
     * 
     *<p>Description: 测试枚举类的switch使用</p>
     * @author zhyi
     * @data 2016年12月1日
     * @time 下午4:07:35
     * @version 1.0
     * 
     * @param simpleEnum
     */
    static void test(SimpleEnum simpleEnum){
    	switch (simpleEnum) {
		case UP:
			System.out.println("UP");
			break;
//		case SimpleEnum.UP://错误使用，不能使用SimpleEnum.UP
//			System.out.println("UP");
//			break;
		case DOWN:
			System.out.println("DOWN");
			break;
		default:
			System.out.println("default");
			break;
		}
    }
     
    public static void main(String[] args) {
//    	Enum<Enum<E>>
    	SimpleEnum simpleEnum[]=SimpleEnum.values();//返回所有该枚举类的所有枚举值
    	System.out.println(SimpleEnum.class);//返回枚举类
    	System.out.println(SimpleEnum.class.getClass());//枚举类的类型（所有类都是Class类的实例）
    	System.out.println(SimpleEnum.class.getSuperclass());//所有枚举类默认继承了抽象类java.lang.Enum
    	System.out.println(SimpleEnum.values().length);
    	System.out.println(simpleEnum[0]);//UP
        System.out.println(SimpleEnum.UP);
        System.out.println(SimpleEnum.valueOf("UP"));
        for (EnumWithConstructor item : EnumWithConstructor.values()) {
            System.out.println(item+" "+item.getValue());
        }
        System.out.println(SimpleEnum.UP.ordinal());
        SimpleEnum enum1=Enum.valueOf(SimpleEnum.class, "DOWN");//手动实例化一个枚举类
        SimpleEnum enum2=Enum.valueOf(SimpleEnum.class, "DOWN");
        System.out.println(enum1==enum2);
        
        System.out.println(Operation.PLUS.eval(2, 3));
        System.out.println(Operation.MINUS.eval(2, 3));
        System.out.println(Operation.TIMES.eval(2, 3));
        System.out.println(Operation.DIVIDE.eval(2, 3));
        
        // EnumSet的使用
        EnumSet<SimpleEnum> directionSet = EnumSet.allOf(SimpleEnum.class);
        for (SimpleEnum direction : directionSet) {
            System.out.println(direction);
        }
 
        // EnumMap的使用
        EnumMap<SimpleEnum, String> directionMap = new EnumMap(SimpleEnum.class);
        directionMap.put(SimpleEnum.UP, "向上");
        directionMap.put(SimpleEnum.DOWN, "向下");
    }
}
/**
 * 
 *<p>Title: Operation</p>
 *<p>Description: 在枚举类中定义抽象方法的时候不能使用abstract关键字将枚举类定义成抽象类
 *（因为系统会自动为它添加abstract关键字），因为枚举类需要显示创建枚举值，
 *而不是作为父类，所以定义每个枚举值时必须为抽象方法提供实现。</p>
 * @author zhyi
 * @data 2016年12月1日
 * @time 下午4:00:21
 * @version 1.0
 *
 */
enum Operation {
    PLUS{
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS{
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES{
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE{
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };
    public abstract double eval(double x, double y);
}
/**
 * 
 *<p>Title: GenderInter</p>
 *<p>Description: 定义Gender接口</p>
 * @author zhyi
 * @data 2016年12月1日
 * @time 下午4:03:04
 * @version 1.0
 *
 */
interface GenderInter {
    void info();
}

/**
 * 
 *<p>Title: Gender</p>
 *<p>Description: 枚举类在实现接口可以为所有枚举值统一实现方法，也可以为每个枚举值分别实现方法</p>
 * @author zhyi
 * @data 2016年12月1日
 * @time 下午4:02:21
 * @version 1.0
 *
 */
enum Gender implements GenderInter{
    MALE("男"){
    	@Override
        public void info() {
            System.out.println("枚举类分别实现方法,男");
        }
    },
    FEMALE("女"){
    	@Override
        public void info() {
            System.out.println("枚举类实现方法,女");
        }
    };
    private final String name;
    private Gender(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
//    @Override
    public void info() {
    	System.out.println("枚举类统一实现方法");
    }
}

/**
 * 1.枚举本身就是一个类。

　　2.它不能有public的构造函数，这样做可以保证客户代码没有办法新建一个enum的实例。     

　　3.所有枚举值都是public static final的。注意这一点只是针对于枚举值，我们可以和在普通类里面定义变量一样定义其它任何类型的非枚举变量，这些变量可以用任何你想用的修饰符。     

　　4.Enum默认实现了java.lang.Comparable接口。     

　　5.Enum覆载了了toString方法，因此我们如果调用Color.Blue.toString()默认返回字符串”Blue”.

　　6.Enum提供了一个valueOf方法，这个方法和toString方法是相对应的。调用valueOf(“Blue”)将返回Color.Blue.因此我们在自己重写toString方法的时候就要注意到这一点，一般来说应该相对应地重写valueOf方法。     

 　　7.Enum还提供了values方法，这个方法使你能够方便的遍历所有的枚举值

　　8.Enum还有一个oridinal的方法，这个方法返回枚举值在枚举类种的顺序。
 */


/**
 * 不可变类：创建该类的实例后，该实例的Field是不可改变的。枚举类应当作为一个不可变类使用。如果要创建自定义的不可变类，需遵循如下规则：
 * 
（1）使用private和final修饰符来修饰该类的Field。

（2）提供带参数的构造函数，用于根据传入参数来初始化类里的Field。

（3）仅为该类的Field提供getter方法，不要为该类的Field提供setter方法。

（4）如果有必要，重写Object类的hashCode和equals方法。
 */

class EnumSetDemo{
//	EnumSet
}
