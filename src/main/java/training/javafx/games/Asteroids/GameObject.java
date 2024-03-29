package training.javafx.games.Asteroids;

import javafx.geometry.Point2D;
import javafx.scene.Node;


public class GameObject
{
    protected Node view;
    private Point2D velocity = new Point2D(0, 0);

    private boolean alive = true;

    public GameObject(Node view)
    {
        this.view = view;
    }

    public void update()
    {
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
    }

    public Node getView()
    {
        return this.view;
    }

    public Point2D getVelocity()
    {
        return this.velocity;
    }

    public void setVelocity(Point2D velocity)
    {
        this.velocity = velocity;
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
        return view.getRotate();
    }

    public void rotateRight()
    {
        view.setRotate(getRotate() + 5);
        this.setVelocity(new Point2D(-Math.cos(Math.toRadians(getRotate())),
                -Math.sin(Math.toRadians(getRotate()))));
    }

    public void rotateLeft()
    {
        view.setRotate(getRotate() - 5);
        this.setVelocity(new Point2D(-Math.cos(Math.toRadians(getRotate())),
                                     -Math.sin(Math.toRadians(getRotate()))));
    }

    public boolean isColliding(GameObject other)
    {
        return getView().getBoundsInParent()
                .intersects(other.getView().getBoundsInParent());
    }

}
