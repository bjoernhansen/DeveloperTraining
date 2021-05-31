package com.javafx.games.ufos_vs_trees;

import com.javafx.games.algebra.MyPoint;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

abstract class GameObject
{
    protected 
        Node shape;
    
    private MyPoint
        direction = new MyPoint(0, 0);   
        
    private double 
        velocity = 0,
        acceleration = 0,    
        friction = 0;
        
    private boolean 
        alive = true;
    
    GameObject(Node view)
    {
        this.shape = view;
    }

    abstract void handleCollision();
    
    void update()
    {
        this.velocity = Math.max(0, this.friction*(this.velocity+this.acceleration));
        this.shape.setTranslateX(this.shape.getTranslateX() + this.velocity * this.direction.getX());
        this.shape.setTranslateY(this.shape.getTranslateY() + this.velocity * this.direction.getY());
    }

    void setVelocity(double velocity)
    {
        this.velocity = velocity;
    }
    
    double getVelocity()
    {
        return this.velocity;
    }
    
    protected void setFriction(double friction)
    {
        this.friction = friction;
    }
    
    Node getShape()
    {       
        return this.shape;
    }

    MyPoint getDirection()
    {
        return this.direction;
    }

    protected void setDirection(double x, double y)
    {
        this.direction.setLocation(x, y);
    }
    
    boolean isAlive()
    {
        return this.alive;
    }

    void setAlive(boolean alive)
    {
        this.alive = alive;
    }  

    void setAcceleration(double acceleration)
    {
        this.acceleration = acceleration;
    }

    boolean isCollidingWith(GameObject other)
    {
        Bounds bounds1 = this.getShape().getBoundsInParent();
        Bounds bounds2 = other.getShape().getBoundsInParent();
        
        double x1 = bounds1.getMinX() + bounds1.getWidth()/2;
        double y1 = bounds1.getMinY() + bounds1.getHeight()/2;
        double x2 = bounds2.getMinX() + bounds2.getWidth()/2;
        double y2 = bounds2.getMinY() + bounds2.getHeight()/2;
        
        Circle c1 = (Circle)this.getShape();
        Circle c2 = (Circle)other.getShape();
        
        double r1 = c1.getRadius();
        double r2 = c2.getRadius();
                   
        double distance = MyPoint.distance(x1, y1, x2, y2);                  
        
        return r1 + r2 > distance;
    }
    
    protected String fromUrlOf(String path)
    {
        return getClass().getResource(path).toString();
    }
}