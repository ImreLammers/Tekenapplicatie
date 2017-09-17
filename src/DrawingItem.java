import java.io.Serializable;
import javafx.scene.paint.Color;

/**
 * Created by Imre on 7-9-2017.
 */
public abstract class DrawingItem implements Serializable {

    public Color color;

    public DrawingItem(){

    }

    public Color getColor(){ return color;}
    public void setColor(Color c){ color = c;}

    public abstract Point getAnchor();
    public abstract double getWidth();
    public abstract double getHeight();

    public abstract void PaintUsing(Paintable paintable);
}
