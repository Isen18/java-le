package 设计模式.adapter;

/**
 * @author Isen
 * @date 2018/12/21 16:16
 * @since 1.0
 */
public class SourceImpl extends AbstractSourceable {
    @Override
    public void method1(){
        System.out.println("SourceImpl 实现方法 method1");
    }
}
