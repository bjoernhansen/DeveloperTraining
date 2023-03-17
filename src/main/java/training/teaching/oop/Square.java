package training.teaching.oop;

final class Square implements GeometricShape
{
    private final Rectangle rectangle;
    
    public Square(double sideLength)
    {
        rectangle = new Rectangle(sideLength, sideLength);
    }
    
    @Override
    public double getPerimeter()
    {
        return rectangle.getPerimeter();
    }
    
    @Override
    public double getArea()
    {
        return rectangle.getArea();
    }
}
