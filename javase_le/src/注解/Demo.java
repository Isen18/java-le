package 注解;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import org.junit.Test;

/**
 * Demo
 *
 * @author Isen
 * @description
 * @date 2018/8/1 16:39
 **/
public class Demo {
    @Test
    public void printTest(int a){
        System.out.println("测试print");
    }

//    @Override
//    @Deprecated
//    @SuppressWarnings()
//    @Documented
//    @Inherited
//    @Repeatable()

}

