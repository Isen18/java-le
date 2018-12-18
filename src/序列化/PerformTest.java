package 序列化;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Isen
 * @date 2018/12/18 20:03
 * @since 1.0
 */
public class PerformTest {

    private static Gson gson = new Gson();

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException{
        //准备数据
        List<Integer> ids = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<School> schools = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            ids.add(i);
            Student student = new Student("stu" + i, 12, (byte) 1, "adress" + 1);
            students.add(student);
        }

        for (int i = 0; i < 10000; i++) {
            School school = new School("sch" + i, i,
                    Arrays.asList(
                            new Student("stu" + i, 12, (byte) 1, "adress" + 1),
                            new Student("stu" + i, 12, (byte) 1, "adress" + 1),
                            new Student("stu" + i, 12, (byte) 1, "adress" + 1)));
            schools.add(school);
        }

        long gson = 0;
        long gson2 = 0;
        long gson3 = 0;
        long fastJson = 0;
        long fastJson2 = 0;
        long fastJson3 = 0;
        long jackson = 0;
        long jackson2 = 0;
        long jackson3 = 0;

        for (int i = 0; i < 10; i++) {
            gson += testGson(ids);
            gson2 += testGson2(students);
            gson3 += testGson3(schools);

            fastJson += testFastJson(ids);
            fastJson2 += testFastJson2(students);
            fastJson3 += testFastJson3(schools);

            jackson += testJackson(ids);
            jackson2 += testJackson2(students);
            jackson3 += testJackson3(schools);

        }

        System.out.println("object -> json 耗时");
        System.out.println("gson=" + gson);
        System.out.println("gson2=" + gson2);
        System.out.println("gson3=" + gson3);
        System.out.println("fastJson=" + fastJson);
        System.out.println("fastJson2=" + fastJson2);
        System.out.println("fastJson3=" + fastJson3);
        System.out.println("jackson=" + jackson);
        System.out.println("jackson2=" + jackson2);
        System.out.println("jackson3=" + jackson3);

    }

    //gson
    private static long testGson(List<Integer> ids){
        long start = System.currentTimeMillis();

        ids.forEach(tmp -> gson.toJson(tmp));

        return System.currentTimeMillis() - start;
    }

    private static long testGson2(List<Student> students){
        long start = System.currentTimeMillis();

        students.forEach(tmp -> gson.toJson(tmp));

        return System.currentTimeMillis() - start;
    }

    private static long testGson3(List<School> schools){
        long start = System.currentTimeMillis();

        schools.forEach(tmp -> gson.toJson(tmp));

        return System.currentTimeMillis() - start;
    }

    //fastjson
    private static long testFastJson(List<Integer> ids){
        long start = System.currentTimeMillis();

        ids.forEach(tmp -> JSON.toJSONString(tmp));

        return System.currentTimeMillis() - start;
    }
    private static long testFastJson2(List<Student> students){
        long start = System.currentTimeMillis();

        students.forEach(tmp -> JSON.toJSONString(tmp));

        return System.currentTimeMillis() - start;
    }
    private static long testFastJson3(List<School> schools){
        long start = System.currentTimeMillis();

        schools.forEach(tmp -> JSON.toJSONString(tmp));

        return System.currentTimeMillis() - start;
    }

    //jackson
    private static long testJackson(List<Integer> ids) throws JsonProcessingException{
        long start = System.currentTimeMillis();

        for (Integer tmp : ids){
            mapper.writeValueAsString(tmp);
        }

        return System.currentTimeMillis() - start;
    }
    private static long testJackson2(List<Student> students) throws JsonProcessingException{
        long start = System.currentTimeMillis();

        for (Student tmp : students){
            mapper.writeValueAsString(tmp);
        }

        return System.currentTimeMillis() - start;
    }
    private static long testJackson3(List<School> schools) throws JsonProcessingException{
        long start = System.currentTimeMillis();

        for (School tmp : schools){
            mapper.writeValueAsString(tmp);
        }

        return System.currentTimeMillis() - start;
    }
}

//简单pojo
class Student implements Serializable {

    private static final long serialVersionUID = -652176005909598787L;
    private String name;
    private int age;
    private byte sex;
    private String address;

    public Student(){}

    public Student(String name, int age, byte sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
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

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

//复杂pojo
class School implements Serializable{

    private static final long serialVersionUID = 8948293884170225690L;
    private String name;
    private int age;
    private List<Student> students;

    public School(){}

    public School(String name, int age, List<Student> students) {
        this.name = name;
        this.age = age;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
