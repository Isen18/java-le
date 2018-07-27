package java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * java8.ParameterNameDemo
 *
 * @author Isen
 * @description
 * @date 2018/7/26 0:46
 **/
public class ParameterNameDemo {
    public static void main(String[] args) throws Exception {
        Method method = ParameterNameDemo.class.getMethod("main", String[].class);
        for(final Parameter parameter: method.getParameters()) {
            System.out.println( "Parameter: " + parameter.getName());
        }
    }
}
