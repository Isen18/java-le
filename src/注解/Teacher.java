package 注解;

import 注解.annotation.GenerateInterface;

/**
 * @author Isen
 * @date 2018/12/20 15:31
 * @since 1.0
 */
//老师类
@GenerateInterface(suffix="IntSuffix")
public class Teacher {

    //教书
    private void teach(){
        System.out.println("teach...");
    }

    //行走
    public void walk(){
        System.out.println("walking");
    }
}
