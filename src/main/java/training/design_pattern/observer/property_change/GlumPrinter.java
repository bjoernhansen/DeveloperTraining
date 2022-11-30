package training.design_pattern.observer.property_change;

import java.beans.PropertyVetoException;

public class GlumPrinter
{
    private String name;
    private int age;
    private String lastBirthdayPresent;

    public GlumPrinter(Glump glump) {
        this.name = glump.getName();
        this.age = glump.getAge();
        glump.addPropertyChangeListener("age", event -> {
            this.age = (int)event.getNewValue();
            this.lastBirthdayPresent = ((Glump)event.getSource()).getLastBirthdayPresent();
            System.out.println("There was change! Age: " + this.age + " " + event.getPropertyName());
        });

        // hier die Variante mit annonymer Klasse anstelle eines Lambdas
        glump.addPropertyChangeListener("name", event -> {
            name = (String)event.getNewValue();
            System.out.println("There was change! Name: " + name);
        });

        glump.addVetoableChangeListener(e -> {

            System.out.println("Property Name: " + e.getPropertyName());
            if ("Klaus".equals( e.getNewValue() ))
            {
                throw new PropertyVetoException( "Glump darf nicht Klaus heißen", e );
            }
        });

    }

    @Override
    public String toString()
    {
        return String.format("My %d year old glump's name is %s and my last birthday present was %s.", this.age, this.name, this.lastBirthdayPresent);
    }
}