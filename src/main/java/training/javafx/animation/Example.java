package training.javafx.animation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Example extends Application
{
    GraphicsContext gc;
    double rotator = 30;
    
    @Override
    public void start(final Stage primaryStage)
    {
        Canvas canvas = new Canvas( 1024, 768);
        gc = canvas.getGraphicsContext2D();

        final Scene scene = new Scene(new Group(canvas), canvas.getWidth(), canvas.getHeight(), Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);

        primaryStage.show();

        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                gc.setFill(Color.GOLD);
                gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
                
                gc.setFill(Color.FORESTGREEN);
                gc.fillOval(rotator,10, 20, 20 );
    
                gc.setFill(Color.INDIANRED);
                gc.fillOval(170+100*Math.sin(rotator/10), 170+100*Math.cos(rotator/10), 20, 20);
                
                rotator += 0.25;
            }
        }.start();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}