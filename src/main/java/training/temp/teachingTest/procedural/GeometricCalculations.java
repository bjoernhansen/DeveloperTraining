package training.temp.teachingTest.procedural;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

class GeometricCalculations
{
    static double calculatePerimeter(GeometricShape geometricShape)
    {
        if(geometricShape instanceof Rectangle)
        {
            Rectangle rectangle = (Rectangle) geometricShape;
            return 2 * rectangle.side1 + 2 * rectangle.side2;
        }
        else if(geometricShape instanceof Triangle)
        {
            Triangle triangle = (Triangle) geometricShape;
            return triangle.side1 + triangle.side2 + triangle.side3;
        }
        else if(geometricShape instanceof Square)
        {
            Square square = (Square) geometricShape;
            return 4 * square.sideLength;
        }
        else if(geometricShape instanceof Circle)
        {
            Circle circle = (Circle) geometricShape;
            return 2 * Math.PI * circle.radius;
            
        }
        throw new InvalidParameterException("Not a valid geometric shape.");
    }
    
    static double calculateArea(GeometricShape geometricShape)
    {
        if(geometricShape instanceof Rectangle)
        {
            Rectangle rectangle = (Rectangle) geometricShape;
            return rectangle.side1 * rectangle.side2;
        }
        else if(geometricShape instanceof Triangle)
        {
            Triangle triangle = (Triangle) geometricShape;
            double s = calculatePerimeter(triangle) / 2;
            return Math.sqrt(s * (s - triangle.side1) * (s - triangle.side2) * (s - triangle.side3));
        }
        else if(geometricShape instanceof Square)
        {
            Square square = (Square) geometricShape;
            return square.sideLength * square.sideLength;
        }
        else if(geometricShape instanceof Circle)
        {
            Circle circle = (Circle) geometricShape;
            return Math.PI * circle.radius;
        }
        throw new InvalidParameterException("Not a valid geometric shape.");
    }
    
    
    static double calculateAreaSum(GeometricShape ... shapes)
    {
        return Stream.of(shapes)
                     .mapToDouble(GeometricCalculations::calculateArea)
                     .sum();
    }
    
    static double calculatePerimeterSum(GeometricShape ... shapes)
    {
        return Stream.of(shapes)
                     .mapToDouble(GeometricCalculations::calculatePerimeter)
                     .sum();
    }
}
