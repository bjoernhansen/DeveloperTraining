package training.design_pattern.observer.javafx_binding;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class UsageOfNumberBinding {


    public static void main(String[] args) {

        IntegerProperty a         = new SimpleIntegerProperty( 3 );
        IntegerProperty b         = new SimpleIntegerProperty( 2 );

        NumberBinding formular    = a.multiply( 2 ).add( b.multiply( 2 ) );

        System.out.println( formular.getValue() ); // 10

        IntegerProperty perimeter = new SimpleIntegerProperty();
        perimeter.bind( formular );

        System.out.println( perimeter.get() );     // 10

        a.set( 6 );

        System.out.println( perimeter.get() );     // 16
    }
}
