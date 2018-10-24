package 泛型.序列化;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Isen
 * @date 2018/9/30 22:32
 * @since 1.0
 */
public class JacksonDemo {
    public static void main(String[] args) throws IOException {

        JsonDemon jsonDemon = new JsonDemon();
        jsonDemon.setList(Arrays.asList((byte)1, (byte)2));

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(jsonDemon);


        //反序列化非泛型对象，对象中的字段可以是泛型类型。
        JsonDemon jsonDemon2 = mapper.readValue(jsonStr, JsonDemon.class);
        System.out.println("jsonDemon2=" + jsonDemon2);
        for(Byte tmp: jsonDemon2.getList()){
            System.out.println("tmp=" + tmp);
        }

        jsonStr = mapper.writeValueAsString(Arrays.asList((byte)1, (byte)2));
        //错误的用法
        List<Byte> list = mapper.readValue(jsonStr, List.class);//list是List<Integer>类型
//        for(Byte b : list){//报错
//            System.out.println(b);
//        }

        //正确的用法
        list = mapper.readValue(jsonStr, new TypeReference<List<Byte>>(){});//list是List<Byte>类型
        for(Byte b : list){
            System.out.println(b);
        }
    }
}