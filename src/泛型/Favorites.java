package 泛型;

import java.util.HashMap;
import java.util.Map;

/**
 * Favorites
 *
 * @author Isen
 * @description
 * @date 2018/8/3 23:38
 **/
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
        if(type == null){
            throw new NullPointerException("type is null");
        }

        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type){
//        return (T)favorites.get(type);
        return type.cast(favorites.get(type));//cast将对象引用动态转换成Class对象所表示的类型。
    }
}
