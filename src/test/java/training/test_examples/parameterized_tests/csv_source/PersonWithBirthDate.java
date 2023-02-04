package training.test_examples.parameterized_tests.csv_source;

import java.time.LocalDate;

public class PersonWithBirthDate
{
    String firstName;
    String lastName;
    
    LocalDate birthDate;
    
    
    public PersonWithBirthDate(String firstName, String lastName, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    
    public String fullName()
    {
        return String.format("%s %s", firstName, lastName);
    }
}
