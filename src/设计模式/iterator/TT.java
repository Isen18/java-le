package 设计模式.iterator;

/**
 * @author Isen
 * @date 2018/12/24 9:33
 * @since 1.0
 */
public class TT {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
