package 集合;

import java.util.AbstractMap;
import java.util.Dictionary;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

public class MapDemo {
	/**
	 * 	Map 是一个键值对(key-value)映射接口。Map映射中不能包含重复的键；每个键最多只能映射到一个值。
		Map 接口提供三种collection 视图，允许以键集、值集或键-值映射关系集的形式查看某个映射的内容。
		Map 映射顺序。有些实现类，可以明确保证其顺序，如 TreeMap；另一些映射实现则不保证顺序，如 HashMap 类。
		Map 的实现类应该提供2个“标准的”构造方法：第一个，void（无参数）构造方法，用于创建空映射；
		第二个，带有单个 Map 类型参数的构造方法，用于创建一个与其参数具有相同键-值映射关系的新映射。
		实际上，后一个构造方法允许用户复制任意映射，生成所需类的一个等价映射。
		尽管无法强制执行此建议（因为接口不能包含构造方法），但是 JDK 中所有通用的映射实现都遵从它。
	 */
//	Map<K, V>
//	Map.Entry<K, V>
	/**
	 * 	SortedMap是一个继承于Map接口的接口。它是一个有序的SortedMap键值映射。
		SortedMap的排序方式有两种：自然排序 或者 用户指定比较器。 插入有序 SortedMap 的所有元素都必须实现 Comparable 接口（或者被指定的比较器所接受）。
		
		另外，所有SortedMap 实现类都应该提供 4 个“标准”构造方法：
		(01) void（无参数）构造方法，它创建一个空的有序映射，按照键的自然顺序进行排序。
		(02) 带有一个 Comparator 类型参数的构造方法，它创建一个空的有序映射，根据指定的比较器进行排序。
		(03) 带有一个 Map 类型参数的构造方法，它创建一个新的有序映射，其键-值映射关系与参数相同，按照键的自然顺序进行排序。
		(04) 带有一个 SortedMap 类型参数的构造方法，它创建一个新的有序映射，其键-值映射关系和排序方法与输入的有序映射相同。无法保证强制实施此建议，因为接口不能包含构造方法。
	 */
//	SortedMap<K, V>
	/**
	 * 	NavigableMap除了继承SortedMap的特性外，它的提供的功能可以分为4类：
		第1类，提供操作键-值对的方法。
		               lowerEntry、floorEntry、ceilingEntry 和 higherEntry 方法，它们分别返回与小于、小于等于、大于等于、大于给定键的键关联的 Map.Entry 对象。
		               firstEntry、pollFirstEntry、lastEntry 和 pollLastEntry 方法，它们返回和/或移除最小和最大的映射关系（如果存在），否则返回 null。
		第2类，提供操作键的方法。这个和第1类比较类似
		               lowerKey、floorKey、ceilingKey 和 higherKey 方法，它们分别返回与小于、小于等于、大于等于、大于给定键的键。
		第3类，获取键集。
		              navigableKeySet、descendingKeySet分别获取正序/反序的键集。
		第4类，获取键-值对的子集。
	 */
//	NavigableMap<K, V>
	/**
	 * 	AbstractMap类提供 Map 接口的骨干实现，以最大限度地减少实现此接口所需的工作。
		要实现不可修改的映射，编程人员只需扩展此类并提供 entrySet 方法的实现即可，该方法将返回映射的映射关系 set 视图。
		通常，返回的 set 将依次在 AbstractSet 上实现。此 set 不支持 add() 或 remove() 方法，其迭代器也不支持 remove() 方法。

		要实现可修改的映射，编程人员必须另外重写此类的 put 方法（否则将抛出 UnsupportedOperationException），
		entrySet().iterator() 返回的迭代器也必须另外实现其 remove 方法。
	 */
//	AbstractMap<K, V>
//	Dictionary<K, V>
}
