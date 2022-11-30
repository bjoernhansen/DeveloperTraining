package training.utilities.intellij_training;

public class TelefonBookEntry
{
    private String firstName;
    private String lastName;
    private String telefonNumber;
    
    
    public TelefonBookEntry(String firstName, String lastName, String telefonNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telefonNumber = telefonNumber;
    }
    
    
    public String getTelefonNumber()
    {
        return telefonNumber;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setTelefonNumber(String telefonNumber)
    {
        this.telefonNumber = telefonNumber;
    }

}
