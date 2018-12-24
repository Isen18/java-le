package 设计模式.adapter;

/**
 * 类的适配器模式
 *
 * @author Isen
 * @date 2018/12/21 16:07
 * @since 1.0
 */
public class ClassAdapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
