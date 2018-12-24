package 设计模式.builder;

/**
 * @author Isen
 * @date 2018/12/21 15:24
 * @since 1.0
 */
public class Computer {
    private int id;
    private int price;
    private String producer;
    private String brand;
    private Displayer displayer;

    private Computer(int id, int price, String producer, String brand, Displayer displayer) {
        this.id = id;
        this.price = price;
        this.producer = producer;
        this.brand = brand;
        this.displayer = displayer;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                ", brand='" + brand + '\'' +
                ", displayer=" + displayer +
                '}';
    }

    public static class Builder{
        private int id;
        private int price;
        private String producer;
        private String brand;
        private Displayer displayer;

        private Builder(){
            //提供默认参数
            this.id = 1;
            this.price = 7777;
            this.producer = "com.isen";
            this.brand = "isen";
            this.displayer = Displayer.builder().build();
        }

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder price(int price){
            this.price = price;
            return this;
        }

        public Builder producer(String producer){
            this.producer = producer;
            return this;
        }

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Computer build(){
            return new Computer(this.id, this.price, this.producer, this.brand, this.displayer);
        }
    }
}