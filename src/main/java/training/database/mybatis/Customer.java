package training.database.mybatis;

import java.time.LocalDate;

public class Customer
{
    // Bezeichner angepasst in der Klasse CustomerMapper
    private int customerIdentification;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int points;
    
    public Customer()
    {
    }
    
    public Customer(int customerIdentification, String firstName, String lastName, LocalDate birthDate, String phone, String address, String city, String state, int points)
    {
        this.customerIdentification = customerIdentification;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.points = points;
    }
    
    public int getCustomerIdentification()
    {
        return customerIdentification;
    }
    
    public void setCustomerIdentification(int customerIdentification)
    {
        this.customerIdentification = customerIdentification;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public LocalDate getBirthDate()
    {
        return birthDate;
    }
    
    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    public void setPoints(int points)
    {
        this.points = points;
    }
    
    @Override
    public String toString()
    {
        return "Person [customerId=" + customerIdentification + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", phone=" + phone + ", address=" + address + ", city=" + city + ", state=" + state + ", points=" + points + "]";
    }
}
