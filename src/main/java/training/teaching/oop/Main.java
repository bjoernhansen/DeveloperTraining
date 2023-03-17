package training.teaching.oop;

class Main
{
    public static void main(String[] args)
    {
        Triangle triangle = new Triangle(10.0, 12.0, 4.0);
        Square square = new Square(8.5);
        Rectangle rectangle = new Rectangle(10, 5);
        Circle circle = new Circle(5.2);
    
        double sumOfAreas = GeometricCalculations.areaSum(square, triangle, rectangle, circle);
        System.out.println("Summe der Flächen: " + sumOfAreas);
    
        double sumOfPerimeters = GeometricCalculations.perimeterSum(square, triangle, rectangle, circle);
        System.out.println("Summe der Umfänge: " + sumOfPerimeters);
    }
}
