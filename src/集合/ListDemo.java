package 集合;
/**
 * 如果涉及到“栈”、“队列”、“链表”等操作，应该考虑用List，具体的选择哪个List，根据下面的标准来取舍。
	(01) 对于需要快速插入，删除元素，应该使用LinkedList。
	(02) 对于需要快速随机访问元素，应该使用ArrayList。
	(03) 对于“单线程环境” 或者 “多线程环境，但List仅仅只会被单个线程操作”，此时应该使用非同步的类(如ArrayList)。
       对于“多线程环境，且List可能同时被多个线程操作”，此时，应该使用同步的类(如Vector)。
 */
/**
 * 
 *<p>Title: ListDemo</p>
 *<p>Description: </p>
 * @author zhyi
 * @data 2016年12月19日
 * @time 下午3:43:00
 * @version 1.0
 *
 */
public class ListDemo {

}
