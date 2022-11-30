package training.design_pattern.observer.property_change;


import java.beans.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class Glump
{
    private final PropertyChangeSupport
        changeSupport = new PropertyChangeSupport( this );

    private final VetoableChangeSupport
        vetos = new VetoableChangeSupport( this );

    private static final LinkedList<String>
        presents = new LinkedList<>(Arrays.asList("Football", "Pullover", "Teddy", "Chocolate", "Flowers"));

    private String
        name,
        lastBirthdayPresent;

    private int
        age;

    Glump(String name)
    {
        this.name = name;
    }

    public void becomeOlder() {
        int oldAge = this.age;
        this.age++;
        Collections.shuffle(presents);
        this.lastBirthdayPresent = presents.peek();

        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(this, "age", oldAge, this.age );
        changeSupport.firePropertyChange( propertyChangeEvent);
        // oder: changeSupport.firePropertyChange( "age", oldAge, this.age );
    }

    public void addPropertyChangeListener( String name, PropertyChangeListener listener ) {

        changeSupport.addPropertyChangeListener( name, listener );
    }


    public void addVetoableChangeListener( VetoableChangeListener vetoChangeListener ) {

        vetos.addVetoableChangeListener( vetoChangeListener );

    }



    public String getName() {
        return name;
    }

    public void setName(String name) throws PropertyVetoException {
        String oldName = this.name;
        this.name = name;
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(this, "name", oldName, this.name);
        vetos.fireVetoableChange( propertyChangeEvent );
        changeSupport.firePropertyChange( propertyChangeEvent );
    }

    public int getAge() {
        return age;
    }

    public String getLastBirthdayPresent() {
        return lastBirthdayPresent;
    }
}
