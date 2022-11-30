package training.design_pattern.observer.javafx_binding.glumpExample;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GlumPrinter
{
    private final StringProperty
            name = new SimpleStringProperty();

    private final IntegerProperty
            age = new SimpleIntegerProperty();

    private final IntegerProperty
            ageInMonth = new SimpleIntegerProperty();


    GlumPrinter(Glump glump)
    {
        this.name.bind(glump.nameProperty());
        this.age.bind(glump.ageProperty());
        NumberBinding formular = this.age.multiply(12);
        this.ageInMonth.bind(formular);
    }

    @Override
    public String toString()
    {
        return String.format("My %d year (%d month) old glump's name is %s.", this.age.get(), this.ageInMonth.get(), this.name.get());
    }
}
