package training.temp.teachingTest.oop;

final class Triangle implements GeometricShape
{
    private final double side1;
    
    private final double side2;
    
    private final double side3;
    
    
    public Triangle(double side1, double side2, double side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double getPerimeter()
    {
        return sideLengthSum();
    }
    
    @Override
    public double getArea()
    {
        double s = sideLengthSum() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    private double sideLengthSum()
    {
        return side1 + side2 + side3;
    }
    
    @Override
    public String toString()
    {
        return "Triangle{" + side1 + ", " + side2 + ", " + side3 + '}';
    }
}
