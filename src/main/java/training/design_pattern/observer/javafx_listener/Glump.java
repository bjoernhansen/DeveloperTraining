package training.design_pattern.observer.javafx_listener;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Glump
{
    private final StringProperty
            name = new SimpleStringProperty();

    private final IntegerProperty
            age = new SimpleIntegerProperty();

    Glump(String name)
    {
        this.name.set(name);
    }

    public void becomeOlder()
    {
        this.age.set(this.age.get() + 1);
    }

    public StringProperty nameProperty() { return name; }

    public IntegerProperty ageProperty() { return age; }
}
