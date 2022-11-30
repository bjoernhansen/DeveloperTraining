package training.utilities.intellij_training;

import java.util.List;


public class Company {

    private final List<Person> employee;

    public Company(List<Person> employee) {

        this.employee = employee;
    }

    public List<Person> getEmployee() {
        return employee;
    }
}
