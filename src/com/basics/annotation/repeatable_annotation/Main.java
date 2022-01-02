package com.basics.annotation.repeatable_annotation;

import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) {


        for(Method method : GummyBearMethodsTest.class.getDeclaredMethods())
        {
            if(method.isAnnotationPresent(GummyBear.class)
            || method.isAnnotationPresent(GummyBearContainer.class) )
            {
                for(GummyBear gummyBear : method.getAnnotationsByType(GummyBear.class))
                {
                    System.out.println(gummyBear.value());
                }
                System.out.println("Annotated with Annotation GummyBear: " + method.isAnnotationPresent(GummyBear.class));
                System.out.println("Annotated with Annotation GummyBearContainer: " + method.isAnnotationPresent(GummyBearContainer.class));
            }



        }

    }

}
