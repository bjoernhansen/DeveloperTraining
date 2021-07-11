package com.javafx.animation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PaintImageToShape extends Application
{
    private static final String RESSOURCE_ROOT_PATH = "gameExamples/pictures/";
    private static final String sunURL = RESSOURCE_ROOT_PATH + "sun.png";
    private static final String briefcaseURL = RESSOURCE_ROOT_PATH + "briefcase.png";
    private static final String mauerURL = RESSOURCE_ROOT_PATH + "mauer_1.jpg";

    @Override public void start(Stage stage) {
        stage.setTitle("Image Pattern");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 450);
        
        Image sun = new Image(fromUrlOf(sunURL));
        Image briefcase = new Image(fromUrlOf(briefcaseURL));
        Image mauer = new Image(fromUrlOf(mauerURL));
        
        Polygon p = new Polygon();

        p.setLayoutX(10);
        p.setLayoutY(10);
        p.getPoints().add(50.0);
        p.getPoints().add(0.0);
        p.getPoints().add(100.0);
        p.getPoints().add(100.0);
        p.getPoints().add(0.0);
        p.getPoints().add(100.0);
  
        
        
        
        scene.setFill(new ImagePattern(mauer, 0, 0, 300, 300, false));
        
        p.setFill(new ImagePattern(sun, 0, 0, 100, 100, false));
        
        root.getChildren().add(p);

        Polygon p2 = new Polygon();

        p2.setLayoutX(10);
        p2.setLayoutY(120);
        p2.getPoints().add(50.0);
        p2.getPoints().add(0.0);
        p2.getPoints().add(100.0);
        p2.getPoints().add(100.0);
        p2.getPoints().add(0.0);
        p2.getPoints().add(100.0);

        p2.setFill(new ImagePattern(sun, 0, 0, 100, 100, false));

        root.getChildren().add(p2);

        Circle circ = new Circle(50);
        circ.setTranslateX(120);
        circ.setTranslateY(10);
        circ.setCenterX(50);
        circ.setCenterY(50);
        circ.setFill(new ImagePattern(briefcase, 0.2, 0.2, 0.4, 0.4, true));

        root.getChildren().add(circ);

        Circle circ2 = new Circle(50);
        circ2.setTranslateX(120);
        circ2.setTranslateY(120);
        circ2.setCenterX(50);
        circ2.setCenterY(50);
        circ2.setFill(new ImagePattern(briefcase, 20, 20, 40, 40, false));

        root.getChildren().add(circ2);
        stage.setScene(scene);
        stage.show();
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