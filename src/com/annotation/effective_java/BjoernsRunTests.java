package com.annotation.effective_java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

class BjoernsRunTests
{
    public static void main(String[] args)
    {
        int annotatedMethods = 0;
        int passedMethods = 0;
        int allMethods = 0;


        Class<?> testClass = Sample.class;
        for(Method method : testClass.getDeclaredMethods())
        {
            if(method.isAnnotationPresent(BjoernTest.class))
            {
                try
                {
                    method.invoke(null);
                    passedMethods++;
                    System.out.println(String.format("Method %s: PASSED", method.getName()));
                }
                catch (InvocationTargetException e)
                {
                    Throwable exception = e.getCause();
                    System.out.println(String.format("Method %s: FAILED with Exception %s", method.getName(), exception));
                }
                catch (Exception e)
                {
                    System.out.println(String.format("Method %s: INVALID TEST", method.getName()));
                }
                annotatedMethods++;
            }
            else
            {
                System.out.println(String.format("Method %s: NO ANNOTATION", method.getName()));
            }
            allMethods++;
        }
    }
}
