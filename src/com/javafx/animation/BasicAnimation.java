package com.javafx.animation;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BasicAnimation extends Application
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    int timer = 0;
    
    
    private double x = 300;

    
    
    @Override
    public void start(final Stage primaryStage)
    {
        primaryStage.setTitle("My JavaFX Test Enviroment");
        
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.RED);
        primaryStage.setScene(scene);
        
        Canvas canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
    
    
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
            switch (event.getButton()) {
                case PRIMARY:
                    x += 20;
                    break;
                case SECONDARY:
                    x -= 20;
                    break;
            }
        });
        
        
        primaryStage.show();
        
        
        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                timer++;
                
                
                if((timer/100)%2==0)
                {
                   x+=3;
                }
                else
                {
                    x-=3;
                }

                
                graphicsContext2D.clearRect(0, 0, primaryStage.getWidth(), primaryStage.getHeight());
        
                
                graphicsContext2D.setFill(Color.GOLD);
                graphicsContext2D.fillOval(10+ x,10,100,100);
    
                
                
            }
        }.start();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
