package training.javafx.animation.gameExamples;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


// Animation of Earth rotating around the sun. (Hello, world!)
public class Example3
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("AnimationTimer Example");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren()
            .add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();


        Image earth = new Image(Objects.requireNonNull(getClass().getResource("/pictures/earth.png"))
                                       .toString());
        Image sun = new Image(Objects.requireNonNull(getClass().getResource("/pictures/sun.png"))
                                     .toString());
        Image space = new Image(Objects.requireNonNull(getClass().getResource("/pictures/space.png"))
                                       .toString());

        System.out.println(getClass().getResource("/pictures/earth.png"));


        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // Clear the canvas
                gc.clearRect(0, 0, 512, 512);

                // background image clears canvas
                gc.drawImage(space, 0, 0);
                gc.drawImage(earth, x, y);
                gc.drawImage(sun, 196, 196);
            }
        }.start();

        stage.show();
    }
}