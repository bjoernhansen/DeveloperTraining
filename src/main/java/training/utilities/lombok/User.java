package training.utilities.lombok;

import lombok.NoArgsConstructor;

import java.io.Serializable;

// @NoArgsConstructor
public class User implements Serializable
{
    private Long id; // will be set when persisting
    
    private String firstName;
    private String lastName;
    private int age;
    
    public User() {
    }
    
    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public Long getId()
    {
        return id;
    }
}
