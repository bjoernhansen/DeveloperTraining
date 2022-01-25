package com.utilities.intellij_training;

import java.util.Objects;


public class Person {

    String firstName;
    String lastName;

    public Person() {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{ " + firstName + " " + lastName + " }";
    }




}