package com.basics.annotation.example;

import java.lang.reflect.Field;
import java.util.Optional;


public class AnnotationExample
{
    @MyAnnotation("Example")
    private String alpha = "123";

    public static void main(final String[] args) throws Exception
    {
        AnnotationExample example = new AnnotationExample();
        Field field = AnnotationExample.class.getDeclaredField("alpha");
        field.setAccessible(true);

        if(field.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
            field.set(example, annotation.value() +  " " + Optional.ofNullable(example.alpha).orElse(""));
        }

        System.out.println(example.alpha);
    }





}

