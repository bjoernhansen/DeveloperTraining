package training.java_basics.annotation.effective_java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BjoernRunTests
{
    private static final Class<BjoernTest>
        ANNOTATION_CLASS = BjoernTest.class;
    
    private static int
        annotatedMethods,
        passedMethods,
        allMethods;
    
    public static void main(String[] args)
    {
        invokeMethodsOf(Sample.class);
        System.out.printf("Report: %d annotated methods; %d passed Methods; %d all methods%n", annotatedMethods, passedMethods, allMethods);
    }
    
    private static void invokeMethodsOf(Class<?> testClass)
    {
        for(Method method : testClass.getDeclaredMethods())
        {
            allMethods++;
            if(method.isAnnotationPresent(ANNOTATION_CLASS))
            {
                annotatedMethods++;
                try
                {
                    method.invoke(null);
                    passedMethods++;
                    System.out.printf("Method %s: PASSED%n", method.getName());
                }
                catch (InvocationTargetException e)
                {
                    Throwable exception = e.getCause();
                    System.out.printf("Method %s: FAILED with Exception %s%n", method.getName(), exception);
                }
                catch (Exception e)
                {
                    System.out.printf("Method %s: FAILED -> INVALID TEST%n", method.getName());
                }
            }
            else
            {
                System.out.printf("Method %s: FAILED -> NO ANNOTATION%n", method.getName());
            }
        }
    }
}
