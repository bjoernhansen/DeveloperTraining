package com.javafx.animation.gameExamples.helper;


import javafx.geometry.Point2D;
import javafx.scene.Node;


public class GameObject
{
    protected Node view;
    private Point2D direction = new Point2D(0, 0);

    private boolean alive = true;
    
    
    

    public GameObject(Node view)
    {
        this.view = view;
    }

    public void update()
    {
        this.view.setTranslateX(this.view.getTranslateX() + this.direction.getX());
        this.view.setTranslateY(this.view.getTranslateY() + this.direction.getY());
    }

    public Node getView()
    {
        return this.view;
    }

    public Point2D getDirection()
    {
        return this.direction;
    }

    public void setDirection(Point2D velocity)
    {
        this.direction = velocity;
    }

    public boolean isAlive()
    {
        return this.alive;
    }

    public boolean isDead()
    {
        return !this.alive;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    public double getRotate()
    {
        return this.view.getRotate();
    }

    public void rotateRight()
    {
        this.view.setRotate(getRotate() + 5);
        this.setDirection(new Point2D(-Math.cos(Math.toRadians(getRotate())),
                -Math.sin(Math.toRadians(getRotate()))));
    }

    public void rotateLeft()
    {
        this.view.setRotate(getRotate() - 5);
        this.setDirection(new Point2D(-Math.cos(Math.toRadians(getRotate())),
                                     -Math.sin(Math.toRadians(getRotate()))));
    }

    public boolean isColliding(GameObject other)
    {
        return getView().getBoundsInParent()
                .intersects(other.getView().getBoundsInParent());
    }

}
