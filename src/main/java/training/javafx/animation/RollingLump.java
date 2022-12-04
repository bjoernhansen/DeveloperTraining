package training.javafx.animation;
import training.javafx.animation.gameExamples.helper.MyPoint;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Objects;

public class RollingLump extends Application implements EventHandler <KeyEvent>
{
    final static int SCENE_WIDTH = 800;
    final static int SCENE_HEIGHT = 600;
    final static int MAX_SPEED = 5;
    
    //Point2D MAX_SPEED = new Point2D(4,4);
    double ballRadius = 40;
    Path path;
    MyPoint speed = new MyPoint(5, 5);
    double xSpeed = MAX_SPEED;
    double rotate_direction = 1;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Basic JavaFX demo");

        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        // Creating Three Circles Shapes
        Circle c1 = new Circle();
        c1.setRadius(this.ballRadius);
        c1.setCenterX(100);
        c1.setCenterY(200);

        Circle c2 = new Circle();
        c2.setRadius(this.ballRadius);
        c2.setCenterX(70);
        c2.setCenterY(235);

        Circle c3 = new Circle();
        c3.setRadius(this.ballRadius);
        c3.setCenterX(110);
        c3.setCenterY(235);

        this.path = (Path)Shape.union(c1, c2);
        this.path = (Path)Shape.subtract(this.path, c3);
        
        //path.setFill(Color.BLUE);

        this.path.setFill(new ImagePattern(new Image(fromUrlOf("/pictures/klumpen.png")), 20, 20, 140, 140, false));
        
        //root.getChildren().add(this.path);

        final Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();
        keyboardNode.setOnKeyPressed(this);
        
        root.getChildren().addAll(this.path, keyboardNode);
        scene.setFill(Color.DARKTURQUOISE);
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer animator = new AnimationTimer()
        {

            @Override
            public void handle(long arg0)
            {
                // UPDATE
                if (RollingLump.this.path.getBoundsInParent().getMaxX() + RollingLump.this.xSpeed + 10 >= SCENE_WIDTH)
                {
                    RollingLump.this.xSpeed = -1 * MAX_SPEED;
                    RollingLump.this.rotate_direction = -RollingLump.this.rotate_direction;
                }
                else if (RollingLump.this.path.getBoundsInParent().getMinX() - RollingLump.this.xSpeed - 10 < 0)
                {
                    RollingLump.this.xSpeed = MAX_SPEED;
                    RollingLump.this.rotate_direction = -RollingLump.this.rotate_direction;
                }
                //ballX += xSpeed;

                // RENDER               
                RollingLump.this.path.setLayoutX(RollingLump.this.path.getLayoutX()+RollingLump.this.xSpeed);
                RollingLump.this.path.setRotate(RollingLump.this.path.getRotate() + RollingLump.this.rotate_direction * 3.5);
            }
            
            
        };
        animator.start();
    }
    
    private String fromUrlOf(String path)
    {
        return Objects.requireNonNull(getClass().getResource(path))
                      .toString();
    }

    @Override
    public void handle(KeyEvent arg0)
    {
        System.out.println("dfff");  
        if (arg0.getCode() == KeyCode.SPACE )
        {
            this.xSpeed *= -1;
        }
    }
}