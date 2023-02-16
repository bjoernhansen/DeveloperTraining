package training.javafx.gui.canvas.snapshot;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Main extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane root = new BorderPane();
            Group group = new Group();
            Scene scene = new Scene(root, Color.BLACK);
            
            Button saveButton = new Button("Save as PNG");
            
            // ---Canvas
            Canvas canvas = new Canvas(500, 500);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.RED);
            gc.fillRect(20, 20, 400, 400);
            
            canvas.setOnMousePressed(event -> {
                gc.setFill(Color.LIGHTGRAY);
                gc.setStroke(Color.GREEN);
                gc.setLineWidth(5);
                gc.beginPath();
                gc.moveTo(event.getX(), event.getY());
                gc.stroke();
            });
            
            canvas.setOnMouseDragged(event -> {
                System.out.println(event.getX());
                gc.lineTo(event.getX(), event.getY());
                gc.stroke();
            });
            
            saveButton.setOnAction(e -> {
                WritableImage image = canvas.snapshot(new SnapshotParameters(), null);
                
                File file = new File("logs/bild.png");
                try
                {
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                }
                catch(IOException e1)
                {
                    e1.printStackTrace();
                }
            });
            root.setRight(saveButton);
            root.setCenter(group);
            group.getChildren()
                 .add(canvas);
            
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
