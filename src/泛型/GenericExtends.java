package 泛型;

import java.util.List;
import org.junit.Test;

/**
 * GenericExtends
 *
 * @author Isen
 * @description
 * @date 2018/7/30 10:36
 **/
public class GenericExtends {

    @Test
    public void test(){
        //普通类与继承
        Object object = null;
        String str = "str";
        object = str;

        Object[] objects = null;
        String[] strs = new String[]{"str1", "str2"};
        objects = strs;
        //报错 不能往String数据中存储整型
//        objects[0] = 11;
    }

    @Test
    public void test2() {
        //泛型类与继承
        List<Object> list = null;
        List<String> list2 = null;
        //出错   List<Object> 不是List<String>的父类
//            list = list2;
        {
            //证明
            //反证：若List<Object>是 List<String>的父类
            list.add(11);
            String str = list2.get(0);//会出错

            //结论：若A是B的父类,但是List<A>不是List<B>的父类
        }
    }
}