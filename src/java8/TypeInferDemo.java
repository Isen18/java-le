package java8;

/**
 * java8.TypeInferDemo
 *
 * @author Isen
 * @description
 * @date 2018/7/26 0:34
 **/
public class TypeInferDemo {

    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        value.getOrDefault( "22", Value.defaultValue());
        //java7 需要用Value.<String>defaultValue()
        value.getOrDefault( "22", Value.<String>defaultValue());
    }
}

class Value<T> {
    public static<T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }
}
