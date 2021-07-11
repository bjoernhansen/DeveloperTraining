package com.javafx.games.Asteroids;

public class MyPoint
{
    private double x;
    private double y;
    
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

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return this.y;
    }

    public void setY(double y)
    {
        this.y = y;
    }
    
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void setLocation(MyPoint point)
    {
        this.x = point.x;
        this.y = point.y;
    }
    
    public void add(double x, double y)
    {
        this.x += x;
        this.y += y;
    }
    
    public void add(MyPoint point)
    {
        this.x += point.x;
        this.y += point.y;
    }
    
    public void addUntil(MyPoint ap, MyPoint max)
    {
        this.x = Math.min(this.x + ap.x, max.x);
        this.y = Math.min(this.y + ap.y, max.y);
    }
    
   
    
 
}
