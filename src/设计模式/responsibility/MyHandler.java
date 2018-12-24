package 设计模式.responsibility;

/**
 * @author Isen
 * @date 2018/12/24 9:42
 * @since 1.0
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + "deal!");
        if (getNextHandler() != null) {
            //传递给下一个handle处理
            getNextHandler().operator();
        }
    }
}
