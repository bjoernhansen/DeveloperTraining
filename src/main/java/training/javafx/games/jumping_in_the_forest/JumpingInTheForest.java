package training.javafx.games.jumping_in_the_forest;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import training.javafx.games.algebra.Math;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Box;
import javafx.stage.Stage;


public class JumpingInTheForest extends Application 
{
    private static final String
        BACKGROUND_IMAGE_PATH = "images/forest.jpg";
                
    static final Dimension 
        SCREEN_SIZE = new Dimension(1024, 768);

    private static final int
        NUMBER_OF_PLATEAUS = 75;
        
    private Boy boy;
    private Group root;
    private Scene scene;
    
    private final List<Plateau>
        plateaus = new ArrayList<>();
    
    
    @Override
    public void start(Stage primaryStage)
    {        
        this.scene = new Scene(getRootWithContent(), SCREEN_SIZE.width, SCREEN_SIZE.height);  
        createAnimationTimer().start();        
        configure(primaryStage);       
    }    
    
    private Parent getRootWithContent()
    {
        this.root = new Group();
        this.createPlateaus();        
        this.boy = new Boy();
        this.root.getChildren().addAll( getKeyboardControls(), 
                                        this.boy.getBounds(), 
                                        this.boy.getView());
        return this.root;
    }
    
    private void createPlateaus()
    {
        for (int i = 0; i < NUMBER_OF_PLATEAUS; i++)
        { 
            double 
                x = i * (21000.0/NUMBER_OF_PLATEAUS) + Math.random.nextInt(200) - 10000,
                y = Math.random.nextInt(450) + 150;
            
            this.addPlateau(new Plateau(), x, y);
        }
    }    
    
    private void addPlateau(Plateau plateau, double x, double y)
    {
        this.plateaus.add(plateau);
        plateau.moveTo(x, y);        
        this.root.getChildren().addAll( plateau.getView(), 
                                        plateau.getBounds());
    }   
    
    private void configure(Stage primaryStage)
    {
        primaryStage.setTitle("Jumping in the Forest");
        primaryStage.setScene(this.scene);
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Box getKeyboardControls()
    {
        final Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();        
        setOnKeyPressed(keyboardNode);
        setOnKeyReleased(keyboardNode);
        return keyboardNode;
    }
    
    private void setOnKeyPressed(Box keyboardNode)
    {
        keyboardNode.setOnKeyPressed(e -> 
        {
            if (e.getCode() == KeyCode.LEFT )            
            {
                if(this.boy.isRunningToTheRight())
                {
                    this.boy.turnLeft();
                }
                this.boy.startAccelerating(); 
            }
            else if (e.getCode() == KeyCode.RIGHT )            
            {
                if(this.boy.isRunningToTheLeft())
                {
                    this.boy.turnRight();
                } 
                this.boy.startAccelerating();
            }
            else if (e.getCode() == KeyCode.SPACE)            
            {
                if(this.boy.isOnTheGround())
                {
                    this.boy.jump();
                    
                }
            }
        });        
    }
    
    private void setOnKeyReleased(Box keyboardNode)
    {
        keyboardNode.setOnKeyReleased(e -> 
        {
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT)            
            {
                this.boy.stopAccelerating();          
            }
        });
    }

    private AnimationTimer createAnimationTimer()
    {
        return new AnimationTimer()
        {
            @Override
            public void handle(long arg0)
            {  
                onUpdate();
            }
        };
    }
    
    private void onUpdate()
    {        
        this.boy.updateAndCheck(this.plateaus);
        moveBackground();
    }

    private void moveBackground()
    {        
        this.scene.setFill(  new ImagePattern(new Image(getBackgroundImageUrl()),
                            -this.boy.getView().getLayoutX(), 
                            8,
                            SCREEN_SIZE.height, SCREEN_SIZE.height, false));        
        this.root.setLayoutX(this.root.getLayoutX() - this.boy.getVelocity().getX());
    }
    
    private String getBackgroundImageUrl()
    {
        return getClass().getResource(JumpingInTheForest.BACKGROUND_IMAGE_PATH).toString();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}