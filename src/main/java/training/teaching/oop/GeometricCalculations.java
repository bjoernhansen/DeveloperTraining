package training.teaching.oop;

import java.util.stream.Stream;

class GeometricCalculations
{
    public static double perimeterSum(GeometricShape ... shapes)
    {
        return Stream.of(shapes)
                     .mapToDouble(GeometricShape::getPerimeter)
                     .sum();
    }
    
    public static double areaSum(GeometricShape ... shapes)
    {
        return Stream.of(shapes)
                     .mapToDouble(GeometricShape::getArea)
                     .sum();
    }
}
