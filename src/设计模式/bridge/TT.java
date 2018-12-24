package 设计模式.bridge;

/**
 * @author Isen
 * @date 2018/12/21 16:58
 * @since 1.0
 */
public class TT {
    public static void main(String[] args) {

        Bridge bridge = new BridgeImpl();

        Sourceable source1 = new SourceImpl();
        bridge.setSource(source1);
        bridge.method();

        Sourceable source2 = new SourceImpl2();
        bridge.setSource(source2);
        bridge.method();
    }
}
