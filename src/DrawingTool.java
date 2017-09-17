import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Imre on 7-9-2017.
 */
public class DrawingTool extends javafx.application.Application {

    private JavaFXPaintable paintable;
    private Drawing drawing;

    public DrawingTool(JavaFXPaintable paintable, Drawing drawing)  {
        this.paintable = paintable;
        this.drawing = drawing;
    }
    public DrawingTool() {}

    public static void main(String[] args) {
        launch(args);
    }

    private void draw()
    {
        drawing.paintUsing(paintable);
    }

    public Drawing getDrawing() {
        return drawing;
    }
    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    public JavaFXPaintable getPaintable() {
        return paintable;
    }
    private void setPaintable(JavaFXPaintable paintable) {
        this.paintable = paintable;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Teken Applicatie");
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
