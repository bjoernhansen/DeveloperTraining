package com.utilities.intellij_training;

import java.util.Arrays;
import java.util.Objects;


public class Person implements Walkable{

    String firstName;
    String lastName;

    public Person() {
        myExtractedMEthod();
    }
    
    private void myExtractedMEthod()
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName)
    {
        
        
        this.firstName = firstName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public boolean getLastName()
    {
        return Objects.nonNull(lastName);
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
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
