package 泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 * PECS
 *
 * @author Isen
 * @description
 * @date 2018/8/3 22:17
 **/
public class PECS {
    @Test
    public void test(){
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = new ArrayList<>();
        numberStack.pushAll(integers);
        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);
    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list){
        Iterator<? extends T> iterator = list.iterator();
        T result = iterator.next();
        while(iterator.hasNext()){
            T t = iterator.next();
            if(t.compareTo(result) > 0){
                result = t;
            }
        }
        return result;
    }
}


class Stack<E>{
    private Object[] elements;
    private int size = 0;
    private static final int DEAFAULT_INITIAL_CAPATIY = 16;
    public Stack(){
        elements = new Object[DEAFAULT_INITIAL_CAPATIY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        E result = (E)elements[--size];
        elements[size] = null;
        return result;
    }

//    public void pushAll(Iterable<E> src){
//        for(E e: src){
//            push(e);
//        }
//    }

    public void pushAll(Iterable<? extends E> src){
        for(E e: src){
            push(e);
        }
    }

//    public void popAll(Collection<E> dst){
//
//    }

    public void popAll(Collection<? super E> dst){
        while (!isEmpty()){
            dst.add(pop());
        }
    }


    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}