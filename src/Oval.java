import java.io.Serializable;

/**
 * Created by Imre on 7-9-2017.
 */
public class Oval extends DrawingItem implements Serializable {

    private Point anchor;
    private double width;
    private double height;
    private double weight;

    public Oval(Point anchor, double width, double height, double weight){
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public Point getAnchor(){
        return anchor;
    }
    public void setAnchor(Point a){
        anchor = a;
    }

    @Override
    public double getWidth() { return width; } ;
    public void setWidth(double w){
        width = w;
    }

    @Override
    public double getHeight() { return height; }
    public void setHeight(double h){ height = h; }

    @Override
    public void PaintUsing(Paintable paintable) { paintable.paint(this); }

    public double getWeight() { return weight; }
    public void setWeight(double w){
        weight = w;
    }

    @Override
    public String toString() {
        return "Oval " +
                "anchor=" + anchor.getX() + "," + anchor.getY() +
                " width=" + width +
                " height=" + height +
                " weight=" + weight +
                ' ';
    }
}
