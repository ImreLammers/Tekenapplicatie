import java.io.File;
import java.io.Serializable;

/**
 * Created by Imre on 7-9-2017.
 */
public class Image extends DrawingItem implements Serializable{

    private File file;
    private Point anchor;
    private Double width;
    private Double height;

    public Image(File file, Point anchor, double width, double height) {
        this.file = file;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public File getFile() { return file; }
    public void setFile(File f){
        file = f;
    }

    @Override
    public Point getAnchor(){ return anchor; }
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

    @Override
    public String toString() {
        return "Image{" +
                "file=" + file +
                ", anchor=" + anchor.getX() + "," + anchor.getY() +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
