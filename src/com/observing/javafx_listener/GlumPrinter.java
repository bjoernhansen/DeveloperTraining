package com.observing.javafx_listener;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;

public class GlumPrinter
{
    private String name;
    private int age;


    GlumPrinter(Glump glump)
    {
        this.name = glump.nameProperty().get();
        this.age = glump.ageProperty().get();

        ChangeListener<String>
                nameChangeListener =
                    (observable, oldValue, newValue) -> {
                        System.out.printf( "Name: %s -> %s%n", oldValue, newValue );
                        this.name = newValue;
                    };

        ChangeListener<Number>
                    ageChangeListener =
                    (observable, oldValue, newValue) -> {
                        System.out.printf( "Age: %d -> %d%n", oldValue, newValue );
                        this.age = (int) newValue;
                    };

        InvalidationListener invalidationListener =
                observable -> System.out.println( "Änderung am " + observable );

        glump.ageProperty().addListener(invalidationListener);
        glump.nameProperty().addListener(nameChangeListener);
        glump.ageProperty().addListener(ageChangeListener);
    }

    @Override
    public String toString()
    {
        return String.format("My %d year old glump's name is %s.", this.age, this.name);
    }
}
