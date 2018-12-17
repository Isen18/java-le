package 泛型;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 * Wildcard
 *
 * @author Isen
 * @description
 * @date 2018/7/30 10:48
 **/
public class Wildcard {

    @Test
    public void test() {
        //通配符?
        //List<?>是所有List<类> 的父类
        //List<?>可以指向任意的List<类>的实例对象，并取出其中的元素，但是不能放入入元素

        List<?> list = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list2.add(12);
        list3.add("bbb");
        list = list2;
        list = list3;

        //list取出存在list3的元素
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //list不能直接通过自己向他的子类放入元素
        //list向list3中存入元素
//           list.add("ccc");//出错

        //特例 空对象
        list.add(null);
    }

    @Test
    public void test2() {
        //边界通配符  ? extends A
        //允许集合中的元素类型是A及其子类（类型通配符上限 类比小于等于号<=）

        List<? extends Number> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        list5.add(12);
        list4 = list5;
        //list4取出存在list5中的元素
        System.out.println(list4.get(0));
        //list4向list5中存入元素
//            list4.add(12);//出错
    }


    @Test
    public void tset3() {
        //边界通配符 ? super A
        //允许集合中的元素类型是A及其父类（类型通配符下限 类比大于等于号>=）

        List<? super Integer> list6 = new ArrayList<>();
        List<Integer> list7 = new ArrayList<>();
        list7.add(12);

        list6 = list7;
        //list6取出存在list7中的元素
        System.out.println(list6.get(0));
        //list6向list7中存入元素
//        list6.add(12);//出错
//        list7=list6;//出错

        //结论：
        //对于泛型，父类可以从子类中取元素，但是不能存元素到子类中
        //或者说可以从通配符泛型类中取出元素，但是不能写入元素
        //体现了，集合中的元素严进宽出，写入集合的元素需要具体类型，而读取集合的元素没有要求
    }
}
