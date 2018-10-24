package 泛型.序列化;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Isen
 * @date 2018/9/30 12:00
 * @since 1.0
 */
public class GsonDemo {

    public static void main(String[] args) {
        Gson gson = new Gson();

        JsonDemon jsonDemon = new JsonDemon();
        jsonDemon.setList(Arrays.asList((byte)1, (byte)2));

        String jsonStr = gson.toJson(jsonDemon);
        System.out.println("jsonStr=" + jsonStr);

        //反序列化非泛型对象，对象中的字段可以是泛型类型。
        JsonDemon jsonDemon2 = gson.fromJson(jsonStr, JsonDemon.class);
        System.out.println("jsonDemon2=" + jsonDemon2);
        for(Byte tmp: jsonDemon2.getList()){
            System.out.println("tmp=" + tmp);
        }

        jsonStr = gson.toJson(Arrays.asList((byte)1, (byte)2));
        //错误的用法
        List<Byte> list = gson.fromJson(jsonStr, ArrayList.class);//list是List<Double>类型
//        for(Byte b : list){//报错
//            System.out.println(b);
//        }

        //正确的用法
        list = gson.fromJson(jsonStr, new TypeToken<List<Byte>>(){}.getType());//list是List<Byte>类型
        for(Byte b : list){
            System.out.println(b);
        }

        // TODO isen 2018/9/30 两种toJson方法区别
        List<Person> personList = Arrays.asList(new Person("张三", 12));
        jsonStr = gson.toJson(personList);
        System.out.println(jsonStr);
        jsonStr = gson.toJson(personList, new TypeToken<List<Person>>(){}.getType());
        System.out.println(jsonStr);
    }
}

class JsonDemon{
    private List<Byte> list;

    public List<Byte> getList() {
        return list;
    }

    public void setList(List<Byte> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "JsonDemon{" +
                "list=" + list +
                '}';
    }
}

class Person{
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}