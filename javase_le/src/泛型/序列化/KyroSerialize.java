package 泛型.序列化;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.objenesis.strategy.StdInstantiatorStrategy;

public class KyroSerialize {
    private final static String TEMP_FILE_PATH = "D:\\mytest\\simplekryo.bin";

    public static void main(String[] args) throws FileNotFoundException {
        long statr = System.currentTimeMillis();
        setSerializeObject();
        System.out.println("kryo序列化的时间 ： "+(System.currentTimeMillis()-statr)+"ms");
        statr = System.currentTimeMillis();
        getSerializeObject();
        System.out.println("kryo反序列化的时间 ： "+(System.currentTimeMillis()-statr)+"ms");

    }
    public static void setSerializeObject() throws FileNotFoundException {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        Output output = new Output(new FileOutputStream(TEMP_FILE_PATH));

        for (int i = 0; i < 1; i++) {
            HashMap<Byte, Integer> stringIntegerHashMap = new HashMap<>();

            stringIntegerHashMap.put((byte)1, i+1);
            stringIntegerHashMap.put((byte)2, i+1);

            kryo.writeObject(output, new Simple("ddd", 10+i, stringIntegerHashMap));
        }
        output.flush();
        output.close();
    }

    public static void getSerializeObject() throws FileNotFoundException {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        Input input = new Input(new FileInputStream(TEMP_FILE_PATH));

        Simple simple = null;
        try {
            while ((simple=kryo.readObject(input,Simple.class)) != null){
                Map<Byte, Integer> map = simple.getMap();
            }
        }catch (KryoException e){

        }

        input.close();
    }

}

