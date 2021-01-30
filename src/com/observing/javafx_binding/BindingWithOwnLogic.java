package com.observing.javafx_binding;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BindingWithOwnLogic {


    public static void main(String[] args) {
        DoubleProperty a = new SimpleDoubleProperty( 6 );

        DoubleProperty b = new SimpleDoubleProperty( 8 );

        DoubleBinding hypotenuse = new DoubleBinding() {

            {

                super.bind( a, b );

            }

            @Override

            protected double computeValue() {

                return Math.sqrt( a.get() * a.get() + b.get() * b.get() );

            }

        };

        System.out.println( hypotenuse.getValue() );    // 10.0

        a.set( 15 );

        System.out.println( hypotenuse.getValue() );    // 17.0
    }
}
