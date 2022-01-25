package com.utilities.intellij_training;

import java.util.List;


public class Company {

    private List<Person> employee;

    public Company(List<Person> employee) {

        this.employee = employee;
    }

    public List<Person> getEmployee() {
        return employee;
    }
}
