import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Imre on 7-9-2017.
 */
public class Controller implements Initializable {

    public Drawing drawing;
    private GraphicsContext gc;
    private JavaFXPaintable paintable;
    @FXML
    Canvas drawingCanvas;
    @FXML
    Button btnPlace;
    @FXML
    ComboBox cbType;
    @FXML
    Button btnRemove;
    @FXML
    ListView lView;
    @FXML
    ColorPicker cpColor;

    private void draw()
    {
        gc.clearRect(0,0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        drawing.paintUsing(paintable);
        lView.setItems(drawing.itemsToObserve());
    }

    @FXML
    private void drawItem(ActionEvent event){
        if(cbType.getSelectionModel().getSelectedItem().toString() == "Oval"){
            Oval oval = new Oval(new Point(120, 120), 75,75,30);
            oval.setColor(cpColor.getValue());
            drawing.addItem(oval);
        }
        if(cbType.getSelectionModel().getSelectedItem().toString() == "Polygon"){
            ArrayList<Point> polygonList = new ArrayList<>();
            polygonList.add(new Point(120.0, 110.0));
            polygonList.add(new Point(65.0, 35.0));
            polygonList.add(new Point(25.0, 110.0));
            Polygon polygon = new Polygon(polygonList);
            polygon.setColor(cpColor.getValue());
            drawing.addItem(polygon);
        }
        if(cbType.getSelectionModel().getSelectedItem().toString() == "Text"){
            PaintedText paintedText = new PaintedText("Dit is tekst", "Century Gothic", new Point(200.0, 150.0), 50, 100);
            paintedText.setColor(cpColor.getValue());
            drawing.addItem(paintedText);
        }
        if(cbType.getSelectionModel().getSelectedItem().toString() == "Image"){
            drawing.addItem(new Image(new File("C:\\Users\\Imre\\Pictures\\Pengu.jpg"), new Point(50.0, 10.0), 300, 300));
        }
        if(cbType.getSelectionModel().getSelectedItem().toString() == "Drawing"){
            //drawing.addItem(drawing.items);
        }
        draw();
    }

    @FXML
    private void removeItem(ActionEvent event){
        DrawingItem itemToRemove = (DrawingItem)lView.getSelectionModel().getSelectedItem();
        drawing.removeItem(itemToRemove);
        draw();
    }

    @FXML
    private void saveDrawingLocal(ActionEvent event) throws IOException, SQLException {
        SerializationMediator sm = new SerializationMediator();
        sm.save(this.drawing);
    }

    @FXML
    private void saveDrawingDB(ActionEvent event) throws IOException, SQLException {
        SerializationMediator sm = new SerializationMediator();
        sm.save(this.drawing);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        gc = drawingCanvas.getGraphicsContext2D();
        paintable = new JavaFXPaintable(gc);
        drawing = new Drawing();
        cbType.getItems().addAll("Oval", "Polygon", "Text", "Image", "Drawing");
        cbType.getSelectionModel().selectFirst();
    }
}

