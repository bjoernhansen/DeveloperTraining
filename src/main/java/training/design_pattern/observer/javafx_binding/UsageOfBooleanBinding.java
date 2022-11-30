package training.design_pattern.observer.javafx_binding;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.binding.BooleanBinding;

public class UsageOfBooleanBinding {


    public static void main(String[] args) {

        StringProperty input = new SimpleStringProperty( "Wings" );
        BooleanBinding isMale = input.isEqualToIgnoreCase( "m" )
                .or( input.isEqualToIgnoreCase( "male" ) );

        System.out.println( isMale.get() );  // false

        input.set( "male" );

        System.out.println( isMale.get() );  // true
    }
}
