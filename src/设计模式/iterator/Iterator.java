package 设计模式.iterator;

/**
 * @author Isen
 * @date 2018/12/24 9:29
 * @since 1.0
 */
public interface Iterator {
    Object previous();

    boolean hasNext();
    Object next();

    Object first();
}
