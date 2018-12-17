package 泛型.序列化;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class OriginalSerialize {
    private final static String TEMP_FILE_PATH = "D:\\mytest\\simple.bin";

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        setSerializzeObject();
        System.out.println("java原生的序列化时间 ： "+ (System.currentTimeMillis()-start)+"ms");

        start = System.currentTimeMillis();
        getSerializeObject();
        System.out.println("java原生的发序列化时间 ： "+(System.currentTimeMillis()-start)+"ms");
    }

    public static void setSerializzeObject() throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream(TEMP_FILE_PATH);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (int i = 0; i < 10000; i++) {
            HashMap<Byte, Integer> stringIntegerHashMap = new HashMap<>();

            stringIntegerHashMap.put((byte)1, i);
            stringIntegerHashMap.put((byte)2, i);

            objectOutputStream.writeObject(new Simple("dada", i+10, stringIntegerHashMap));

        }
        objectOutputStream.flush();
        objectOutputStream.close();
    }
    public static void getSerializeObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(TEMP_FILE_PATH);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Simple simple = null;
        try {
            while ((simple = (Simple)objectInputStream.readObject()) != null){
            }
        }catch (EOFException e){

        }

        objectInputStream.close();
    }

}
