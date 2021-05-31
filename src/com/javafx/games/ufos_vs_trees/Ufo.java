package com.javafx.games.ufos_vs_trees;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


class Ufo extends GameObject
{
    private static final String UFO_IMAGE_PATH = "images/ufo.png";
    
    static final double
        UFO_RADIUS = 50,
        FRICTION = 0.985;
    
    
    Ufo()
    {
        super(new Circle(UFO_RADIUS, UFO_RADIUS, UFO_RADIUS));   
        this.initialize();        
        ((Circle)this.getShape()).setFill(new ImagePattern(new Image(fromUrlOf(UFO_IMAGE_PATH)), 0, 0, 2*UFO_RADIUS, 2*UFO_RADIUS, false));
    }
        
    private void initialize()
    {
        this.setDirection(-1, 0);  
        this.setAcceleration(-0.001);
        this.setFriction(FRICTION);        
    }

    private double getRotate()
    {
        return this.shape.getRotate();
    }

    void rotateRight()
    {
        this.shape.setRotate(getRotate() + 5);
        this.setDirection( -Math.cos(Math.toRadians(getRotate())),
                           -Math.sin(Math.toRadians(getRotate())));
    }

    void rotateLeft()
    {
        this.shape.setRotate(getRotate() - 5);
        this.setDirection( -Math.cos(Math.toRadians(getRotate())),
                           -Math.sin(Math.toRadians(getRotate())));
    }

    @Override
    void handleCollision()
    {
        this.setVelocity(0);
    }     
}