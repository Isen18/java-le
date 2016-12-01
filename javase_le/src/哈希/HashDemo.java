package 哈希;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * HashCode的官方文档定义:
 * hashcode方法返回该对象的哈希码值。支持该方法是为哈希表提供一些优点，例如，java.util.Hashtable 提供的哈希表。 
 * hashCode 的常规协定是： 
 * 在 Java 应用程序执行期间，在同一对象上多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是对象上 equals 比较中所用的信息没有被修改。
 * 从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。 
 * 如果根据 equals(Object) 方法，两个对象是相等的，那么在两个对象中的每个对象上调用 hashCode 方法都必须生成相同的整数结果。 
 * 以下情况不 是必需的：如果根据 equals(java.lang.Object) 方法，两个对象不相等，那么在两个对象中的任一对象上调用 hashCode 方法必定会生成不同的整数结果。
 * 但是，程序员应该知道，为不相等的对象生成不同整数结果可以提高哈希表的性能。 
 * 实际上，由 Object 类定义的 hashCode 方法确实会针对不同的对象返回不同的整数。
 * （这一般是通过将该对象的内部地址转换成一个整数来实现的，但是 JavaTM 编程语言不需要这种实现技巧。） 
 * 当equals方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。
 * 
 */
/**
 * 
 *<p>Title: HashDemo</p>
 *<p>Description: 哈希测试。哈希主要运用于HashTable、HashSet的查找，而equal主要运用于对象相等比较。</p>
 * @author zhang
 * @data 2016年12月1日
 * @time 下午9:22:09
 * @version 1.0
 *
 */
public class HashDemo {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T1 t12 = new T1();
		System.out.println(t1==t12);//==用于比较对象是否是同一个对象。
		System.out.println(t1.equals(t12));//equals用于比较两个对象是否相等
		System.out.println(t1);
//		Integer 
//		Boolean
//		String
//		ArrayList<E>
//		HashMap<K, V>
		/**
		 * Object的equal()调用的是==
		 * 基本数据类型的包装类重写了equal().用于比较相同类型对象的值是否相等.并且也重写了hashCode()
		 * String也重写了equal().用于比较字符串是否相等.并且也重写了hashCode()
		 * 作为hashTable或者hashSet的key对象（自定义类型），一般要重写equal和hashCode，
		 * 因为key的hashCode和equal会被调用判断是否相等，若不重写，则为Object的equal(==),
		 * class Key{
		 * 		private value;
		 * 		Key(value){
		 * 			this.value=value;
		 * 		}
		 * }
		 * Key key1=new Key(1);
		 * Key key2=new Key(1);
		 * key1==key2 返回false，若作为Map的key,完全不符合我们的期望,因为我们会认为他们相等，应当重写equal和hashCode
		 */
	}
}
class T1{
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
