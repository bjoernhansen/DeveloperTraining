package com.javafx.games.ufos_vs_trees;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.javafx.games.ufos_vs_trees.Ufo.UFO_RADIUS;


public class UfosVsAliens extends Application
{
    private static final String
        BACKGROUND_IMAGE_PATH = "images/pavement.jpg",
        CRASH_SOUND_PATH =      "sounds/crash.m4a",
        UFO_SOUND_PATH =        "sounds/ufo.wav";

    private static final Dimension 
        SCREEN_SIZE = new Dimension(1024, 768);
     
    private static final int
        NUMBER_OF_TREES = 100;

    private static final double
        TREE_GROWTH_RADIUS = 4;
    
    private Pane root;
    private Scene scene;
    private List<GameObject> trees = new ArrayList<>();
    private Ufo ufo;
    
    private MediaPlayer 
        crashSound,
        petrolSound;

    
    private Parent prepareContent()
    {        
        this.root = new Pane();        
        this.root.setPrefSize(SCREEN_SIZE.width, SCREEN_SIZE.height);        
        this.createTrees();
        this.ufo = new Ufo();
        this.addGameObject(this.ufo, SCREEN_SIZE.width/2.0  - UFO_RADIUS,
                                     SCREEN_SIZE.height/2.0 - UFO_RADIUS);
        return this.root;
    }

    private void initializeSounds()
    {
        this.crashSound = new MediaPlayer(new Media(fromUrlOf(CRASH_SOUND_PATH)));
        this.petrolSound = new MediaPlayer(new Media(fromUrlOf(UFO_SOUND_PATH)));
        this.petrolSound.setCycleCount(MediaPlayer.INDEFINITE);
    }
    
    private void addTree(GameObject tree, double x, double y)
    {
        this.trees.add(tree);
        addGameObject(tree, x, y);
    }

    private void addGameObject(GameObject object, double x, double y)
    {
        object.getShape().setTranslateX(x);
        object.getShape().setTranslateY(y);
        this.root.getChildren().add(object.getShape());
    }

    private void onUpdate()
    {
        this.ufo.update();
        checkForAndHandleCollsions();        
        moveBackground();
    }

    private void checkForAndHandleCollsions()
    {
        for (GameObject tree: this.trees)
        {            
            if(tree.isAlive() && this.ufo.isCollidingWith(tree))
            {
                playCrashSound(); 
                this.ufo.handleCollision();  
                tree.handleCollision();                
            }            
        }
    }

    private void playCrashSound()
    {
        this.crashSound.stop();
        this.crashSound.play();
    }
   
    private void moveBackground()
    {        
        this.scene.setFill(  new ImagePattern(new Image(fromUrlOf(BACKGROUND_IMAGE_PATH)),
                            -this.ufo.getShape().getTranslateX(), 
                            -this.ufo.getShape().getTranslateY(),
                            300, 300, false));       
        
        this.root.relocate( this.root.getLayoutX() - this.ufo.getVelocity() * this.ufo.getDirection().getX(),
                            this.root.getLayoutY() - this.ufo.getVelocity() * this.ufo.getDirection().getY());
    }

    
    @Override
    public void start(Stage primaryStage)
    {        
        primaryStage.setTitle("Ufos vs. Trees");
        
        initializeSounds();
        this.scene = new Scene(prepareContent());         
        createAnimationTimer().start();        
        primaryStage.setScene(this.scene);
        setControls(primaryStage);
        primaryStage.show();
    }
    
    private AnimationTimer createAnimationTimer()
    {
        return new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                onUpdate();
            }
        };
    }

    private void createTrees()
    {
        for (int i = 0; i < NUMBER_OF_TREES; i++)
        {  
            Random random = new Random();
            double x, y;
            
            if(random.nextBoolean())
            {
                x = 0.65 * SCREEN_SIZE.width + random.nextDouble() * TREE_GROWTH_RADIUS * SCREEN_SIZE.width;
            }
            else
            {
                x = 0.35 * SCREEN_SIZE.width - random.nextDouble() * TREE_GROWTH_RADIUS * SCREEN_SIZE.width;
            }
            if(random.nextBoolean())
            {
                y = 0.65 * SCREEN_SIZE.height + random.nextDouble() * TREE_GROWTH_RADIUS * SCREEN_SIZE.height;
            }
            else
            {
                y = 0.35 * SCREEN_SIZE.height - random.nextDouble() * TREE_GROWTH_RADIUS * SCREEN_SIZE.height;
            }    
            
            this.addTree(new Tree(), x, y);
        }
    }

    private void setControls(Stage primaryStage)
    {
        setOnKeyPressed(primaryStage.getScene());
        setOnKeyReleased(primaryStage.getScene()); 
    }
    
    private void setOnKeyPressed(Scene scene2)
    {
        scene2.setOnKeyPressed(e -> 
        {
            if (e.getCode() == KeyCode.LEFT)
            {
                this.ufo.rotateLeft();
            }
            else if (e.getCode() == KeyCode.RIGHT)
            {
                this.ufo.rotateRight();
            }
            else if (e.getCode() == KeyCode.SPACE)
            {
                this.ufo.setAcceleration(0.20);
                this.petrolSound.setAutoPlay(true);
            }
        });
    }

    private void setOnKeyReleased(Scene scene2)
    {
        scene2.setOnKeyReleased(e -> 
        {            
            if (e.getCode() == KeyCode.SPACE)
            {
                this.ufo.setAcceleration(-0.01);
                this.petrolSound.setAutoPlay(false);
                this.petrolSound.stop();
            }
        });        
    }
    
    private String fromUrlOf(String path)
    {
        return getClass().getResource(path).toString();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
