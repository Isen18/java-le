package 序列化.fastjson;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Isen
 * @date 2018/12/17 23:04
 * @since 1.0
 */
public class Demo {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "张三");
//        T t = new T();
//        t.setA(12);
//        t.setIds(Arrays.asList(12, 18));
////        t.setMap(map);
//
//        System.out.println(JSON.toJSONString(t));
       ;
        System.out.println(JSON.toJSONString( Arrays.asList(12, 12)));
    }
}

class T implements Serializable {
    private int a;
    private List<Integer> ids;
    private Map<String, String> map;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}