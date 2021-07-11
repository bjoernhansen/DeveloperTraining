package com.javafx.animation;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleVolcano extends Application
{
    
    private static final int STAR_COUNT = 200;

    final Rectangle[] nodes = new Rectangle[STAR_COUNT];
    final double[] angles = new double[STAR_COUNT];
    final long[] start = new long[STAR_COUNT];

    private final Random random = new Random();

    double rotator = 120;
    
    @Override
    public void start(final Stage primaryStage)
    {     
        for (int i = 0; i < STAR_COUNT; i++)
        {
            this.nodes[i] = new Rectangle(this.random.nextInt(31)+10, this.random.nextInt(31)+10, new Color(Math.random(), Math.random(), Math.random(), 1));
            this.angles[i] = this.random.nextGaussian();
            this.start[i] = this.random.nextInt(2000000000);
            
            //random.
        }
        final Scene scene = new Scene(new Group(this.nodes), 1024, 768, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        //primaryStage.setResizable(false);
        //primaryStage.setOpacity(0.5);
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); 
        primaryStage.show();

        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                final double width = 0.5 * primaryStage.getWidth();
                final double height = 0.5 * primaryStage.getHeight();
                final double radius = Math.sqrt(2) * Math.max(width, height);
                RectangleVolcano.this.rotator += 0.015;
                for (int i = 0; i < STAR_COUNT; i++)
                {
                    final Node node = RectangleVolcano.this.nodes[i];
                    final double angle = RectangleVolcano.this.angles[i] + RectangleVolcano.this.rotator;
                    final long t = (now - RectangleVolcano.this.start[i]) % 2000000000;
                    final double d = t * radius / 2000000000.0;
                    node.setTranslateX(Math.cos(angle) * d + width);
                    node.setTranslateY(Math.sin(angle) * d + height);
                }
            }
        }.start();
    }

    public static void main(String[] args)
    {
        /*System.out.println(Math.cos(Math.PI));
        System.out.println(Math.sin(Math.PI));
        
        */
        
        
        launch(args);
    }

}