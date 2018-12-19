package 序列化;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Isen
 * @date 2018/12/18 20:03
 * @since 1.0
 */
public class PerformTest {

    private static Gson gson = new Gson();

    private static ObjectMapper mapper = new ObjectMapper();

    private static List<Integer> ids = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<School> schools = new ArrayList<>();

    private static List<String> idsJSON = new ArrayList<>();
    private static List<String> studentsJSON = new ArrayList<>();
    private static List<String> schoolsJSON = new ArrayList<>();

    private static String idsStrJson;

    private static int caseSize = 10000;
    private static int caseNum = 100;
    private static double caseNum2 = 100.;

    public static void main(String[] args) throws IOException {
        initData();

        testObject2Json();

        testJson2Object();
    }

    private static void initData(){
        for (int i = 0; i < caseSize; i++) {
            //准备数据object
            ids.add(i);
            Student student = new Student("stu" + i, 12, (byte) 1, "adress" + 1);
            students.add(student);

            School school = new School("sch" + i, i,
                    Arrays.asList(
                            new Student("stu" + i, 12, (byte) 1, "adress" + 1),
                            new Student("stu" + i, 12, (byte) 1, "adress" + 1),
                            new Student("stu" + i, 12, (byte) 1, "adress" + 1)));
            schools.add(school);

            //准备数据json
            idsJSON.add(PerformTest.gson.toJson(i));
            studentsJSON.add(PerformTest.gson.toJson(student));
            schoolsJSON.add(PerformTest.gson.toJson(school));
        }

        idsStrJson = gson.toJson(ids);
    }

    private static void testObject2Json()  throws JsonProcessingException{
        long gson = 0;
        long gson2 = 0;
        long gson3 = 0;
        long gson4 = 0;
        long fastJson = 0;
        long fastJson2 = 0;
        long fastJson3 = 0;
        long fastJson4 = 0;
        long jackson = 0;
        long jackson2 = 0;
        long jackson3 = 0;
        long jackson4 = 0;

        for (int i = 0; i < caseNum; i++) {
            gson += testGson(ids);
            gson2 += testGson2(students);
            gson3 += testGson3(schools);
            gson4 += testGson4(ids);

            fastJson += testFastJson(ids);
            fastJson2 += testFastJson2(students);
            fastJson3 += testFastJson3(schools);
            fastJson4 += testFastJson4(ids);

            jackson += testJackson(ids);
            jackson2 += testJackson2(students);
            jackson3 += testJackson3(schools);
            jackson4 += testJackson4(ids);

        }

        System.out.println("object -> json 耗时");
        System.out.println("gson=" + gson / caseNum2);
        System.out.println("gson2=" + gson2 / caseNum2);
        System.out.println("gson3=" + gson3 / caseNum2);
        System.out.println("gson4=" + gson4 / caseNum2);
        System.out.println("fastJson=" + fastJson/ caseNum2);
        System.out.println("fastJson2=" + fastJson2/ caseNum2);
        System.out.println("fastJson3=" + fastJson3/ caseNum2);
        System.out.println("fastJson4=" + fastJson4/ caseNum2);
        System.out.println("jackson=" + jackson/ caseNum2);
        System.out.println("jackson2=" + jackson2/ caseNum2);
        System.out.println("jackson3=" + jackson3/ caseNum2);
        System.out.println("jackson4=" + jackson4/ caseNum2);
    }

    private static void testJson2Object()  throws IOException{
        long gson = 0;
        long gson2 = 0;
        long gson3 = 0;
        long gson4 = 0;
        long fastJson = 0;
        long fastJson2 = 0;
        long fastJson3 = 0;
        long fastJson4 = 0;
        long jackson = 0;
        long jackson2 = 0;
        long jackson3 = 0;
        long jackson4 = 0;

        for (int i = 0; i < caseNum; i++) {
            gson += testGsonJSON2Object(idsJSON);
            gson2 += testGsonJSON2Object2(studentsJSON);
            gson3 += testGsonJSON2Object3(schoolsJSON);
            gson4 += testGsonJSON2Object4(idsStrJson);

            fastJson += testFastJsonJSON2Object(idsJSON);
            fastJson2 += testFastJsonJSON2Object2(studentsJSON);
            fastJson3 += testFastJsonJSON2Object3(schoolsJSON);
            fastJson4 += testFastJsonJSON2Object4(idsStrJson);

            jackson += testJacksonJSON2Object(idsJSON);
            jackson2 += testJacksonJSON2Object2(studentsJSON);
            jackson3 += testJacksonJSON2Object3(schoolsJSON);
            jackson4 += testJacksonJSON2Object4(idsStrJson);

        }

        System.out.println("object -> json 耗时");
        System.out.println("gson=" + gson / caseNum2);
        System.out.println("gson2=" + gson2 / caseNum2);
        System.out.println("gson3=" + gson3 / caseNum2);
        System.out.println("gson4=" + gson4 / caseNum2);
        System.out.println("fastJson=" + fastJson/ caseNum2);
        System.out.println("fastJson2=" + fastJson2/ caseNum2);
        System.out.println("fastJson3=" + fastJson3/ caseNum2);
        System.out.println("fastJson4=" + fastJson4/ caseNum2);
        System.out.println("jackson=" + jackson/ caseNum2);
        System.out.println("jackson2=" + jackson2/ caseNum2);
        System.out.println("jackson3=" + jackson3/ caseNum2);
        System.out.println("jackson4=" + jackson4/ caseNum2);
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

    private static long testGson4(List<Integer> ids){
        long start = System.currentTimeMillis();

        gson.toJson(ids);

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
    private static long testFastJson4(List<Integer> ids){
        long start = System.currentTimeMillis();

        JSON.toJSONString(ids);

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
    private static long testJackson4(List<Integer> ids) throws JsonProcessingException{
        long start = System.currentTimeMillis();

        mapper.writeValueAsString(ids);

        return System.currentTimeMillis() - start;
    }


    //json->object
    //gson
    private static long testGsonJSON2Object(List<String> ids){
        long start = System.currentTimeMillis();

        ids.forEach(tmp -> gson.fromJson(tmp, Integer.class));

        return System.currentTimeMillis() - start;
    }

    private static long testGsonJSON2Object2(List<String> students){
        long start = System.currentTimeMillis();

        students.forEach(tmp -> gson.fromJson(tmp, Student.class));

        return System.currentTimeMillis() - start;
    }

    private static long testGsonJSON2Object3(List<String> schools){
        long start = System.currentTimeMillis();

        schools.forEach(tmp -> gson.fromJson(tmp, School.class));

        return System.currentTimeMillis() - start;
    }
    private static long testGsonJSON2Object4(String ids){
        long start = System.currentTimeMillis();

        gson.fromJson(ids, new TypeToken<List<Integer>>(){}.getType());

        return System.currentTimeMillis() - start;
    }

    //fastjson
    private static long testFastJsonJSON2Object(List<String> ids){
        long start = System.currentTimeMillis();

        ids.forEach(tmp -> JSON.parseObject(tmp, Integer.class));

        return System.currentTimeMillis() - start;
    }
    private static long testFastJsonJSON2Object2(List<String> students){
        long start = System.currentTimeMillis();

        students.forEach(tmp -> JSON.parseObject(tmp, Student.class));

        return System.currentTimeMillis() - start;
    }
    private static long testFastJsonJSON2Object3(List<String> schools){
        long start = System.currentTimeMillis();

        schools.forEach(tmp -> JSON.parseObject(tmp, School.class));

        return System.currentTimeMillis() - start;
    }
    private static long testFastJsonJSON2Object4(String ids){
        long start = System.currentTimeMillis();

        JSON.parseArray(ids, Integer.class);

        return System.currentTimeMillis() - start;
    }

    //jackson
    private static long testJacksonJSON2Object(List<String> ids) throws IOException {
        long start = System.currentTimeMillis();

        for (String tmp : ids){
            mapper.readValue(tmp, Integer.class);
        }

        return System.currentTimeMillis() - start;
    }
    private static long testJacksonJSON2Object2(List<String> students) throws IOException{
        long start = System.currentTimeMillis();

        for (String tmp : students){
            mapper.readValue(tmp, Student.class);
        }

        return System.currentTimeMillis() - start;
    }
    private static long testJacksonJSON2Object3(List<String> schools) throws IOException{
        long start = System.currentTimeMillis();

        for (String tmp : schools){
            mapper.readValue(tmp, School.class);
        }

        return System.currentTimeMillis() - start;
    }
    private static long testJacksonJSON2Object4(String ids) throws IOException{
        long start = System.currentTimeMillis();

        mapper.readValue(ids, new TypeReference<List<Integer>>(){});

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
