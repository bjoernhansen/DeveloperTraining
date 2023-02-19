package training.basics.annotation.effective_java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionRunTests
{
    private static final Class<ExceptionTest>
        ANNOTATION_CLASS = ExceptionTest.class;
    
    private static int
        annotatedMethods,
        passedMethods,
        allMethods;
    
    public static void main(String[] args) throws ClassNotFoundException
    {
        invokeMethodsOf(Sample2.class);
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
                    boolean hasThrownValidException = false;
                    Class<? extends Throwable> [] excTypes = method.getAnnotation(ExceptionTest.class).value();

                    for( Class<? extends Throwable> excType : excTypes)
                    {
                        if(excType.isInstance(exception))
                        {
                            passedMethods++;
                            hasThrownValidException = true;
                            break;
                        }
                    }
                    if(hasThrownValidException)
                    {
                        System.out.printf("Method %s: PASSED with Exception %s%n", method.getName(), exception);
                    }
                    else
                    {
                        System.out.printf("Method %s: FAILED with wrong Exception %s%n", method.getName(), exception);
                    }
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
