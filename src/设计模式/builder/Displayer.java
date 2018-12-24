package 设计模式.builder;

/**
 * @author Isen
 * @date 2018/12/21 15:36
 * @since 1.0
 */
public class Displayer{
    private int width;
    private int height;

    private Displayer(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Displayer{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int width;
        private int height;
        private Builder(){
            //提供默认参数
            this.width = 20;
            this.height = 23;
        }

        public Builder width(int width){
            this.width = width;
            return this;
        }

        public Builder height(int height){
            this.height = height;
            return this;
        }

        public Displayer build(){
            return new Displayer(this.width, this.height);
        }
    }
}
