package 设计模式.memento;

/**
 * @author Isen
 * @date 2018/12/24 15:00
 * @since 1.0
 */
public class Storage {
    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
