package training.teaching.oop;

public class Circle implements GeometricShape
{
    private final double radius;
    
    public Circle(double radius)
    {
        this.radius = radius;
    }
    
    @Override
    public double getPerimeter()
    {
        return Math.PI * 2 * radius;
    }
    
    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
}
