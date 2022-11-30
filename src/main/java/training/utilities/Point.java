package training.utilities;

import java.awt.geom.Point2D;

public final class Point
{
    private final double
        x;
    
    private final double
        y;
    
    
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public static Point of(Point2D startPosition)
    {
        return new Point(startPosition.getX(), startPosition.getY());
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public Point2D asPoint2D()
    {
        return new Point2D.Double(x, y);
    }
}