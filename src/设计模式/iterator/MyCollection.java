package 设计模式.iterator;

/**
 * @author Isen
 * @date 2018/12/24 9:30
 * @since 1.0
 */
public class MyCollection implements Collection {

    public String string[] = {"A","B","C","D","E"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}
