package 线程.原子类;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicStampedReference;
/**
 * 
 * 根据修改的数据类型，可以将JUC包中的原子操作类可以分为4类。
 * 
 * 1. 基本类型: AtomicInteger, AtomicLong, AtomicBoolean ;
 * 2. 数组类型: AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray ;
 * 3. 引用类型: AtomicReference, AtomicStampedReference, AtomicMarkableReference ;
 * 4. 对象的属性修改类型: AtomicIntegerFieldUpdater, AtomicLongFieldUpdater, AtomicReferenceFieldUpdater 。
 * 
 * 这些类存在的目的是对相应的数据进行原子操作。所谓原子操作，是指操作过程不会被中断，保证数据操作是以原子方式进行的。
 */
/**
 * 
 *<p>Title: AtomicClassDemo</p>
 *<p>Description: </p>
 * @author zhang
 * @data 2016年12月6日
 * @time 下午10:36:12
 * @version 1.0
 *
 */
public class AtomicClassDemo {
//	AtomicLong
//	AtomicLongArray
//	AtomicReference
//	AtomicStampedReference
//	AtomicMarkableReference
//	AtomicIntegerFieldUpdater
}
