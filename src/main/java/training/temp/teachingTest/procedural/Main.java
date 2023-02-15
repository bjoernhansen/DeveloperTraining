package training.temp.teachingTest.procedural;

class Main
{
    public static void main(String[] args)
    {
        Triangle triangle = new Triangle(10.0, 12.0, 4.0);
        Square square = new Square(8.5);
        Rectangle rectangle = new Rectangle(10, 5);
        
        double sumOfArea = GeometricCalculations.calculateAreaSum(square, triangle, rectangle);
    
        System.out.println(sumOfArea);
    }
}