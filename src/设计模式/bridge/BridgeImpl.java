package 设计模式.bridge;

/**
 * @author Isen
 * @date 2018/12/21 16:58
 * @since 1.0
 */
public class BridgeImpl extends Bridge {
    @Override
    public void method(){
        getSource().method();
    }
}
