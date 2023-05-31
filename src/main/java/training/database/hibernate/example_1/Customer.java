package training.database.hibernate.example_1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerId;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    private String address;
    
    private String city;
    
    private String state;
    
    private int points;
    
    @OneToMany(mappedBy = "customer")
    Set<Order> orders;
    
    /*
    
    Example for ManyToMany:
    
    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name="student_kurs",
				joinColumns={@JoinColumn(name="id_student")},
				inverseJoinColumns={@JoinColumn(name="id_kurs")}
	)
	private Set<Kurs> kurse = new HashSet(0);
  
     */
     
    public Customer()
    {
    }
    
    public Customer(String firstName, String lastName, String address, String city, String state, int points)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.points = points;
    }
    
    public Integer getCustomerId()
    {
        return customerId;
    }
    
    public void setCustomerId(Integer customerId)
    {
        this.customerId = customerId;
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
        return firstName + " " + lastName + " (ID: " + customerId + ", Orders: " + getOrdersAsText() + ")";
    }
    
    private String getOrdersAsText()
    {
        return orders.stream()
                     .map(Order::getOrderId)
                     .map(id -> Integer.toString(id))
                     .collect(Collectors.joining(", "));
    }
}
