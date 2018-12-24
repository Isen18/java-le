package 设计模式.memento;

/**
 * @author Isen
 * @date 2018/12/24 14:59
 * @since 1.0
 */
public class Memento {
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
