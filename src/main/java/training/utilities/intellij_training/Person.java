package training.utilities.intellij_training;

import java.util.Objects;


public class Person implements Walkable
{
    private String firstName;
    
    private String lastName;
    
    
    public Person()
    {
        this.firstName = "Klaus";
        this.lastName = "Peter";
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return Objects.requireNonNull(lastName);
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    @Override
    public String toString()
    {
        return "Person{ " + firstName + " " + lastName + " }";
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName);
    }
}
