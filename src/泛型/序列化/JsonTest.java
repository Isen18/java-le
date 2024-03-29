package 泛型.序列化;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Isen
 * @date 2018/9/30 15:07
 * @since 1.0
 */
public class JsonTest {

    private static ObjectMapper mapper = new ObjectMapper();
    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        Map<String, List<Long>> map = new HashMap<>();
        map.put("one", Arrays.asList(10001L, 10002L, 10003L, 10004L));
        map.put("two", Arrays.asList(20001L, 20002L, 20003L, 20004L));
        map.put("three", Arrays.asList(30001L, 30002L, 30003L, 30004L));
        map.put("four", Arrays.asList(40001L, 40002L, 40003L, 40004L));

        String json = new Gson().toJson(map);
        System.err.println("=======================错误示范=====================");
        //Gson
        Map<String, List<Long>> mapResult = gson.fromJson(json, Map.class);
        System.out.println("通过Gson转换...");
//        printType(mapResult);
        System.out.println(mapResult);
        //Json
        Map<String, List<Long>> jsonMapResult = mapper.readValue(json, Map.class);
        System.out.println("通过Jackson转换...");
//      printType(jsonMapResult);

        System.out.println(jsonMapResult);
        System.out.println("=======================正确做法=====================");
        //Gson
        Map<String, List<Long>> mapResult1 = gson.fromJson(json, new TypeToken<Map<String, List<Long>>>(){}.getType());
        System.out.println("通过Gson转换...");
        printType(mapResult1);
        System.out.println(mapResult1);
        //Json
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Long>> jsonMapResult1 = mapper.readValue(json, new TypeReference<Map<String, List<Long>>>(){});
        System.out.println("通过Jackson转换...");
        printType(jsonMapResult1);

        System.out.println(jsonMapResult1);

    }

    public static void printType(Map<String, List<Long>> map) {
        for (Map.Entry<String, List<Long>> entry : map.entrySet()) {
            System.out.println("key 类型:" + entry.getKey().getClass() + ", value类型:"
                    + entry.getValue().getClass() + ", List中元素类型" + entry.getValue().get(0)
                    .getClass());
        }

    }
}
