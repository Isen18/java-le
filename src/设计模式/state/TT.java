package 设计模式.state;

/**
 * @author Isen
 * @date 2018/12/24 15:04
 * @since 1.0
 */
public class TT {

    public static void main(String[] args) {

        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();
    }
}
