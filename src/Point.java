import java.io.Serializable;

/**
 * Created by Imre on 7-9-2017.
 */
public class Point implements Serializable {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}