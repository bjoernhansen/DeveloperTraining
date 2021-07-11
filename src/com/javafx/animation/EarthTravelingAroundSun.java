package com.javafx.animation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EarthTravelingAroundSun extends Application
{   
    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle( "Timeline Example" );
     
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
     
        Canvas canvas = new Canvas( 800, 600 );
        root.getChildren().add( canvas );
     
        GraphicsContext gc = canvas.getGraphicsContext2D();
      
        Image earth = new Image(fromUrlOf( "gameExamples/pictures/earth_2.png") );
        Image sun   = new Image( fromUrlOf("gameExamples/pictures/sun_2.png" ));
        Image space = new Image( fromUrlOf("gameExamples/pictures/space_2.jpg") );
     
        final long startNanoTime = System.nanoTime();
     
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
     
                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);
     
                // background image clears canvas
                gc.drawImage( space, 0, 0 );
                gc.drawImage( earth, x, y );
                gc.drawImage( sun, 96, 96 );
                
                gc.setFill( Color.RED );
                gc.setStroke( Color.BLACK );
                gc.setLineWidth(2);
                Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
                gc.setFont( theFont );
                gc.fillText( "Hello, World!", x, y );
                gc.strokeText( "Hello, World!", x, y );
            }
        }.start();
     
        theStage.show();
    }
    
    private String fromUrlOf(String path)
    {
        return getClass().getResource(path).toString();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}