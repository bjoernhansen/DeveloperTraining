package com.java_basics.annotation.effective_java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionRunTests
{
    public static void main(String[] args) throws ClassNotFoundException {
        int annotatedMethods = 0;
        int passedMethods = 0;
        int allMethods = 0;


        Class<?> testClass = Sample2.class;
        for(Method method : testClass.getDeclaredMethods())
        {
            allMethods++;
            if(method.isAnnotationPresent(ExceptionTest.class))
            {
                annotatedMethods++;
                try
                {
                    method.invoke(null);
                    System.out.println(String.format("Method %s: FAILED -> no exception", method.getName()));
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
                        System.out.println(String.format("Method %s: PASSED with Exception %s", method.getName(), exception));
                    }
                    else
                    {
                        System.out.println(String.format("Method %s: FAILED with wrong Exception %s", method.getName(), exception));
                    }
                }
                catch (Exception e)
                {
                    System.out.println(String.format("Method %s: FAILED -> INVALID TEST", method.getName()));
                }
            }
            else
            {
                System.out.println(String.format("Method %s: FAILED -> NO ANNOTATION", method.getName()));
            }
        }
    }
}
