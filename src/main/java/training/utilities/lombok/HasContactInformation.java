package training.utilities.lombok;

public interface HasContactInformation
{
    String getFirstName();
    
    void setFirstName(String firstName);
    
    String getFullName();
    
    String getLastName();
    
    void setLastName(String lastName);
    
    String getPhoneNr();
    
    void setPhoneNr(String phoneNr);
}