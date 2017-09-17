import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Imre on 7-9-2017.
 */
public class Polygon extends DrawingItem implements Serializable {

    private ArrayList<Point> vertices;
    public Double weight;

    public Polygon(ArrayList<Point> vertices, double weight) {
        this.vertices = vertices;
        this.weight = weight;
    }
    public Polygon(ArrayList<Point> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Point> getVertices(){
        return vertices;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double w){
        weight = w;
    }

    @Override
    public Point getAnchor() { return null; }

    @Override
    public double getWidth() { return 0; }

    @Override
    public double getHeight() { return 0; }

    @Override
    public void PaintUsing(Paintable paintable) {
        paintable.paint(this);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "vertices=" + vertices.size() +
                " weight=" + weight +
                '}';
    }
}
