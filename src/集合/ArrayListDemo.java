package 集合;

import java.util.*;
import java.util.concurrent.*;
public class ArrayListDemo {

    public static void main(String[] args) {
//    	ArrayList<E>
    	
    	testAccessEfficiecy();
    	
//    	testCopy();
    }
    
    private static void testAccessEfficiecy(){
    	List list = new ArrayList();
        for (int i=0; i<100000; i++)
            list.add(i);
        isRandomAccessSupported(list);
        iteratorThroughRandomAccess(list) ;
        iteratorThroughIterator(list) ;
        iteratorThroughFor2(list) ;
    }
    
    private static void testCopy(ArrayList<Integer> arrayList){
    	copyFromArrayList1(arrayList);
    	copyFromArrayList2(arrayList);
    	copyFromArrayList3(arrayList);
    }
    
 // toArray(T[] contents)调用方式一
	public static Integer[] copyFromArrayList1(ArrayList<Integer> arrayList) {
	    Integer[] newText = new Integer[arrayList.size()];
	    arrayList.toArray(newText);
	    return newText;
	}

	// toArray(T[] contents)调用方式二。最常用！
	public static Integer[] copyFromArrayList2(ArrayList<Integer> arrayList) {
	    Integer[] newText = arrayList.toArray(new Integer[0]);
	    return newText;
	}

	// toArray(T[] contents)调用方式三
	public static Integer[] copyFromArrayList3(ArrayList<Integer> arrayList) {
	    Integer[] newText = new Integer[arrayList.size()];
	    Integer[] newStrings = arrayList.toArray(newText);
	    return newStrings;
	}
    
    private static void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }

    }

    public static void iteratorThroughRandomAccess(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i=0; i<list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval+" ms");
    }

    public static void iteratorThroughIterator(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval+" ms");
    }


    public static void iteratorThroughFor2(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Object obj:list)
            ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval+" ms");
    }
}
