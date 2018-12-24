package 设计模式.iterator;

/**
 * @author Isen
 * @date 2018/12/24 9:28
 * @since 1.0
 */
public interface Collection {

    Iterator iterator();

    Object get(int i);

    int size();
}
