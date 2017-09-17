/**
 * Created by Imre on 7-9-2017.
 */
public interface Paintable {
    void paint(Oval oval);
    void paint(Polygon polygon);
    void paint(PaintedText text);
    void paint(Image image);
}
