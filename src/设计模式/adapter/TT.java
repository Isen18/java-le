package 设计模式.adapter;

import org.junit.Test;

/**
 * @author Isen
 * @date 2018/12/21 16:08
 * @since 1.0
 */
public class TT {
    @Test
    public void testClassAdapter(){
        Targetable target = new ClassAdapter();
        target.method1();
        target.method2();
    }

    @Test
    public void testWrapper(){
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }

    @Test
    public void testAbstractSourceable(){
        Sourceable sourceable = new SourceImpl();
        Sourceable sourceable2 = new SourceImpl2();

        sourceable.method1();
        sourceable.method2();

        sourceable2.method1();
        sourceable2.method2();
    }

}
