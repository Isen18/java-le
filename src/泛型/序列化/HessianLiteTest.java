package 泛型.序列化;

import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import java.util.HashMap;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author Isen
 * @date 2018/9/30 16:30
 * @since 1.0
 */
public class HessianLiteTest {

    @Test
    public void test() throws IOException {
        Map<String, Byte> map = new HashMap<>();
        map.put("age", (byte) 18);
        byte[] bytes = serialize(map);
        Map<String, Byte> object = (Map<String, Byte>) deserialize(bytes);
//        Byte age = object.get("age");//无法从Integer转为Byte
//        System.out.println(age);

        Byte by = (byte)2233;
        bytes = serialize(by);
        Object ob = deserialize(bytes);
        System.out.println("ob" + ob.getClass());//类型是Integer
    }

    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output hessian2Output = new Hessian2Output(os);
        byte[] buff = null;
        try {
            hessian2Output.writeObject(obj);
            hessian2Output.flushBuffer();
            buff = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hessian2Output.close();
        }
        return buff;
    }

    private static Object deserialize(byte[] buff) throws IOException {
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(buff);
            Hessian2Input hessian2Input = new Hessian2Input(is);
            return hessian2Input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
