package training.basics.annotation.new_annotation;

import java.util.Arrays;
import java.util.Collections;

@ClassSelectionAnnotation(MyFirstClass.class)
public class Main
{
    public static void main(String[] args)
    {
        printAnnotatedContentOfSelectedClass();
    }
    
    private static void printAnnotatedContentOfSelectedClass()
    {
        Arrays.stream(Main.class.getAnnotationsByType(ClassSelectionAnnotation.class))
              .findFirst()
              .map(ClassSelectionAnnotation::value)
              .map(aClass -> aClass.getAnnotationsByType(MyCustomAnnotation.class))
              .map(Arrays::asList)
              .orElse(Collections.emptyList())
              .stream()
              .findFirst()
              .map(MyCustomAnnotation::value)
              .map(Arrays::asList)
              .orElse(Collections.emptyList())
              .forEach(System.out::println);
    }
}
