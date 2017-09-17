import java.io.Serializable;

/**
 * Created by Imre on 7-9-2017.
 */
public class PaintedText extends DrawingItem implements Serializable{

    public String content;
    public String fontname;
    public Point anchor;
    public Double width;
    public Double height;

    public PaintedText(String content, String fontName, Point anchor, double width, double height) {
        this.content = content;
        this.fontname = fontName;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public String getContent() { return content; }
    public void setContent(String c) { content = c; }

    public String getFontname() { return fontname; }
    public void setFontname(String f) { fontname = f; }

    @Override
    public Point getAnchor() { return anchor; }
    public void setAnchor(Point a) { anchor = a; }

    @Override
    public double getWidth() { return width; } ;
    public void setWidth(double w){
        width = w;
    }

    @Override
    public double getHeight() { return height; }
    public void setHeight(double h){ height = h; }

    @Override
    public void PaintUsing(Paintable paintable)
    {
        paintable.paint(this);
    }

    @Override
    public String toString() {
        return "PaintedText{" +
                "content='" + content + '\'' +
                " fontName='" + fontname + '\'' +
                " anchor=" + anchor.getX() + "," + anchor.getY() +
                " width=" + width +
                " height=" + height +
                '}';
    }
}