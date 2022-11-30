package training.javafx.games.Asteroids;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Racing extends Application
{
    private static final String 
        groundURL = "pavement.jpg";
    
    private static final Dimension 
        CAR_SIZE = new Dimension (100, 60),
        SCREEN_SIZE = new Dimension (800, 600);
    
    private Pane root;
    private Scene scene;    
    
    private final List<GameObject> trees = new ArrayList<>();
    private GameObject player;
    
    
    private Parent createContent()
    {
        root = new Pane();
        root.setPrefSize(SCREEN_SIZE.width, SCREEN_SIZE.height);
        
        
        
        player = new Player();
        
        
        
        
        
        
        addGameObject(player, (SCREEN_SIZE.width-CAR_SIZE.width)/2.0, (SCREEN_SIZE.height-CAR_SIZE.width)/2.0);
        
        AnimationTimer timer = new AnimationTimer()
        {            
            @Override
            public void handle(long now)
            {
                onUpdate();                 
            }
        };
        timer.start();
        
          
        return root;
    }
     
    
    private void addEnemy(GameObject enemy, double x, double y)
    {
        trees.add(enemy);
        addGameObject(enemy, x, y);
    }
    
    private void addGameObject(GameObject object, double x, double y)
    {
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        root.getChildren().add(object.getView());
    }
   
        
    private void onUpdate()
    {
        for(GameObject enemy : trees)
        {
            if(enemy.isColliding(player))
            {
                enemy.setAlive(false);               
                root.getChildren().removeAll(enemy.getView());
            }
        }
               
        trees.removeIf(GameObject::isDead);        
        trees.forEach(GameObject::update);
        
        player.update();
        
        scene.setFill(new ImagePattern(
                new Image(groundURL), 
                -player.getView().getTranslateX() , 
                -player.getView().getTranslateY() , 
                300, 300, false));  
        
        root.relocate(  root.getLayoutX() - player.getVelocity().getX(),
                        root.getLayoutY() - player.getVelocity().getY());
        
        
         
        
        if(Math.random() < 0.02)
        {
            addEnemy(   new Enemy(), 
                        Math.random() * root.getWidth(), 
                        Math.random() * root.getHeight());
        }
        
    }
    
    private static class Player extends GameObject
    {
        public Player()
        {
            super(new Rectangle(CAR_SIZE.width, CAR_SIZE.height, Color.BLUE));   
            this.setVelocity(new Point2D(-1, 0));        
            ((Rectangle)this.getView()).setFill(new ImagePattern(new Image("car.png"), 0, 0, CAR_SIZE.width, CAR_SIZE.height, false));
        }        
    }
    
    private static class Enemy extends GameObject
    {
        public Enemy()
        {
            super(new Circle(15, 15, 15, Color.RED));            
        }        
    }
    
           
    
    @Override
    public void start(Stage primaryStage)
    {        
        this.scene = new Scene(createContent());        
                
        primaryStage.setScene(scene);   
            
        
        
        
        
        primaryStage.getScene().setOnKeyPressed(e-> {
            if(e.getCode() == KeyCode.LEFT)
            {
                player.rotateLeft();
            }
            else if(e.getCode() == KeyCode.RIGHT)
            {
                player.rotateRight();
            }
            else if(e.getCode() == KeyCode.SPACE)
            {
            
            }
        });   
               
        
        primaryStage.show();        
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    
    
    
    
    
    
}
