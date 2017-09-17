/**
 * Created by Imre on 7-9-2017.
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Drawing extends DrawingItem implements Serializable {
    public String name;
    public ArrayList<DrawingItem> items;
    private ObservableList<DrawingItem> observableList;

    public Drawing(String name, ArrayList<DrawingItem> items) {
        this.name = name;
        this.items = items;
    }

    public Drawing(){
        items = new ArrayList<>();
        observableList = FXCollections.observableList(items);
    }

    @Override
    public Point getAnchor() {
        return null;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    public String GetName(){
        return name;
    }
    public void SetName(String n){
        name = n;
    }

    public void addItem(DrawingItem item) { items.add(item); }
    public void removeItem(DrawingItem item)
    {
        items.remove(item);
    }

    public void EditDrawingItem() {
        DrawingItem previousState;
    }
    public void DeleteDrawingItem(DrawingItem drawingItem) {
        items.remove(items.indexOf(drawingItem));
    }

    @Override
    public void PaintUsing(Paintable paintable) {}

    public void paintUsing(Paintable paint)
    {
        for(DrawingItem x : items)
        {
            x.PaintUsing(paint);
        }
    }

    public ObservableList<DrawingItem> itemsToObserve(){
        return FXCollections.unmodifiableObservableList(observableList);
    }

    //Als de X en de Y samen kleinen zijn dan de X en Y van b, wordt er -1 returned. Als ze gelijk zijn 0 en anders 1.
    class AnchorComperator implements Comparator<DrawingItem> {
        @Override
        public int compare(DrawingItem a, DrawingItem b) {
            return a.getAnchor().getX() + a.getAnchor().getY() < b.getAnchor().getX() + b.getAnchor().getY() ? -1 : a.getAnchor().getX() + a.getAnchor().getY() == b.getAnchor().getX() + b.getAnchor().getY() ? 0 : 1;
        }
    }

    //Een klein opzetje van Overlapping en hoe ik dit zou bekijken. Het enige wat nog mist is een algoritme in de Class BoundingBox die berekend of het punt zich in de box bevindt.
    //Maar omdat ik tijd te kort heb ben ik hier niet aan toegekomen.
    //public boolean overlaps(DrawingItem item) {
    //return insideBoundingBox(item.getAnchor());
    //}

    //public boolean insideBoundingBox(Point point) {
    // for (int i = 0; i < items.size(); i++) {
    //BoundingBox boundingBox = new BoundingBox(items.get(i).getAnchor().getX(), items.get(i).getAnchor().getY(), items.get(i).getWidth(), items.get(i).getHeight());
    //if (boundingBox contains point) {
    //return true;
    //}
    //}
    //return false;
    //}
}
