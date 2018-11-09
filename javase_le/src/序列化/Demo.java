package 序列化;

import com.google.gson.Gson;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Isen
 * @date 2018/10/30 16:43
 * @since 1.0
 */
public class Demo {

    public static void main(String[] args) {

//        DateFormat dateFormat = new SimpleDateFormat();
//        String string = dateFormat.format(null);
//        System.out.println(string);
        BigDecimal bigDecimal = BigDecimal.valueOf(1.55);
        System.out.println(bigDecimal);
        BigDecimal bigDecimal2 = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);

        Gson gson = new Gson();
        Man man = new Man(11, "张三");
        String jsonStr = gson.toJson(man);

        System.out.println(jsonStr);

        Person person = gson.fromJson(jsonStr, Person.class);
        System.out.println(person);
    }
}

class Person{
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

class Man{
    private int age;
    private String name;

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}