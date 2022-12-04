package training.javafx.animation;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class FractionOfSun extends Application
{
    private static final String
        IMAGE_FILE_PATH = "/pictures/sun_2.png";
    
    @Override
    public void start(Stage stage)
    {
        // load the image
        Image image = new Image(fromUrlOf(IMAGE_FILE_PATH));

        // simple displays ImageView the image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);

        // resizes the image to have width of 100 while preserving the ratio and
        // using
        // higher quality filtering method; this ImageView is also cached to
        // improve performance
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(100);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        iv2.setRotate(90);

        // defines a viewport into the source image (achieving a "zoom" effect)
        // and
        // displays it rotated
        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        Rectangle2D viewportRect = new Rectangle2D(40, 35, 10, 30);
        iv3.setViewport(viewportRect);
        iv3.setRotate(90);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(iv1);
        box.getChildren().add(iv2);
        box.getChildren().add(iv3);
        root.getChildren().add(box);

        stage.setTitle("ImageView");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setScene(scene);
        //stage.sizeToScene();
        stage.show();
    }
    
    private String fromUrlOf(String path)
    {
        return Objects.requireNonNull(getClass().getResource(path))
                      .toString();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}