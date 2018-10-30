package 序列化;

import com.google.gson.Gson;

/**
 * @author Isen
 * @date 2018/10/30 16:43
 * @since 1.0
 */
public class Demo {

    public static void main(String[] args) {
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