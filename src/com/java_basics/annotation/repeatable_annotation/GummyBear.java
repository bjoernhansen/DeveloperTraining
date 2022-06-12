package com.java_basics.annotation.repeatable_annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(GummyBearContainer.class)
public @interface GummyBear {
    String value();
}
