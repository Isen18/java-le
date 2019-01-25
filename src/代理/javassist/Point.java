package 代理.javassist;

/**
 * @author Isen
 * @date 2019/1/25 16:20
 * @since 1.0
 */
public class Point {
    private int x;
    private int y;

    public Point(){}
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
