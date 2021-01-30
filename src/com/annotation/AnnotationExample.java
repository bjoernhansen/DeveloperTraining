package com.annotation;

import java.lang.reflect.Field;


public class AnnotationExample
{
    @MyAnnotation("Example")
    private String alpha;

    public static void main(final String[] args) throws Exception
    {
        AnnotationExample example = new AnnotationExample();
        Field field = AnnotationExample.class.getDeclaredField("alpha");
        field.setAccessible(true);

        if(field.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
            field.set(example, annotation.value());
        }

        System.out.println(example.alpha);
    }





}

