package training.utilities.intellij_training;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Company
{
    private final List<Person> employee = new ArrayList<>();
    
    public Company(List<Person> employee)
    {
        Optional.ofNullable(employee).ifPresent(this.employee::addAll);
    }
    
    public List<Person> getEmployee()
    {
        return employee;
    }
}
