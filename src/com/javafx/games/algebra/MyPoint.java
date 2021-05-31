package com.javafx.games.algebra;

public class MyPoint
{
    public static final MyPoint 
        ORIGIN = new MyPoint(0, 0);
    
    private double 
        x, 
        y;

    public MyPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public MyPoint(MyPoint point)
    {
        this.x = point.x;
        this.y = point.y;
    }

    public double getX()
    {
        return this.x;
    }

    public void setX(double new_x)
    {
        this.x = new_x;
    }
    
    public double getY()
    {
        return this.y;
    }

    public void setY(double new_y)
    {
        this.y = new_y;
    }
        
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void setLocation(MyPoint point)
    {
        this.setLocation(point.x, point.y);
    }

    public void add(double x2, double y2)
    {
        this.x += x2;
        this.y += y2;
    }

    public void add(MyPoint point)
    {
        this.x += point.x;
        this.y += point.y;
    }

    public void addUntil(MyPoint ap, MyPoint max)
    {
        this.x = java.lang.Math.min(this.x + ap.x, max.x);
        this.y = java.lang.Math.min(this.y + ap.y, max.y);
    }
    
    public void normalize()
    {
        final double magnitude = this.magnitude();
        
        if (magnitude != 0.0)
        {
           this.setLocation( this.getX() / magnitude, 
                             this.getY() / magnitude);
        }
    }
    
    public double magnitude()
    {
        return java.lang.Math.sqrt(this.x * this.x + this.y * this.y);
    }
        
    public static double distance(double x1, double y1, double x2, double y2) 
    {
        double a = x1 - x2;
        double b = y1 - y2;
        return java.lang.Math.sqrt(a * a + b * b);
    }
}
