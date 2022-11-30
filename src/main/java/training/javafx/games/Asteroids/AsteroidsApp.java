package training.javafx.games.Asteroids;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;
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


public class AsteroidsApp extends Application
{
    public static final String PAVEMENT_IMG_PATH = "img/pavement.jpg";
    
    private Pane root;
    private Scene scene;
    
    private final List<GameObject> bullets = new ArrayList<>();
    private final List<GameObject> enemies = new ArrayList<>();
    
    private GameObject player;
    
    private Parent createContent()
    {
        root = new Pane();
        root.setPrefSize(600, 600);
        
        enableDragging(root);
        
        player = new Player();
        player.setVelocity(new Point2D(1, 0));
        
        addGameObject(player, 300, 300);
        
        AnimationTimer timer = new AnimationTimer()
        {            
            @Override
            public void handle(long now)
            {
                onUpdate();  
                System.out.println(now);
                System.out.println(System.nanoTime());
                
            }
        };
        timer.start();
        return root;
    }
    
    private void addBullet(GameObject bullet, double x, double y)
    {
        bullets.add(bullet);
        addGameObject(bullet, x, y);
    }
    
    private void addEnemy(GameObject enemy, double x, double y)
    {
        enemies.add(enemy);
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
        for(GameObject bullet : bullets)
        {
            for(GameObject enemy : enemies)
            {
                if(bullet.isColliding(enemy))
                {
                    enemy.setAlive(false);
                    bullet.setAlive(false);
                    
                    root.getChildren().removeAll(bullet.getView(), enemy.getView());
                }
            }
        }
        
        bullets.removeIf(GameObject::isDead);
        enemies.removeIf(GameObject::isDead);
        
        bullets.forEach(GameObject::update);
        enemies.forEach(GameObject::update);
        
        player.update();
        scene.setFill(new ImagePattern(
                new Image(fromUrlOf(PAVEMENT_IMG_PATH)),
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
            super(new Rectangle(40, 20, Color.BLUE));            
        }        
    }
    
    private static class Enemy extends GameObject
    {
        public Enemy()
        {
            super(new Circle(15, 15, 15, Color.RED));            
        }        
    }
    
    private static class Bullet extends GameObject
    {
        public Bullet()
        {
            super(new Circle(5, 5, 5, Color.BROWN));            
        }    
    }        
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.scene = new Scene(createContent());        
        scene.setFill(new ImagePattern(new Image(fromUrlOf(PAVEMENT_IMG_PATH)), 0, 0, 300, 300, false));
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
                Bullet bullet = new Bullet();
                bullet.setVelocity(player.getVelocity().normalize().multiply(5));
                addBullet(bullet, player.getView().getTranslateX(), player.getView().getTranslateY());
            }
        });
        primaryStage.show();        
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    private void enableDragging(Node node)
    {
        final ObjectProperty<Point2D> mouseAnchor = new SimpleObjectProperty<>();
        node.setOnMousePressed(event -> mouseAnchor
                .set(new Point2D(event.getSceneX(), event.getSceneY())));
        node.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseAnchor.get().getX();
            double deltaY = event.getSceneY() - mouseAnchor.get().getY();
            node.relocate(node.getLayoutX() + deltaX,
                    node.getLayoutY() + deltaY);
            mouseAnchor.set(new Point2D(event.getSceneX(), event.getSceneY()));
            scene.setFill(new ImagePattern(new Image(fromUrlOf(PAVEMENT_IMG_PATH)), event.getSceneX(), event.getSceneY(), 300, 300, false));
        });
    }
    
    private String fromUrlOf(String path)
    {
        return Objects.requireNonNull(getClass().getResource(path))
                      .toString();
    }
}