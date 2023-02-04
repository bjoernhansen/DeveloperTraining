package training.utilities.intellij_training;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        TelefonBookEntry telefonBookEntry = new TelefonBookEntry("Klaus", "Meier", "017696522342");
        Company company = new Company(null);
        Person person = new Person();
    
        System.out.println(Integer.MAX_VALUE);
        
        System.out.println("H");
    
    
        try
        {
            String firstName = telefonBookEntry.getFirstName();
        
            Company company1 = new Company(company.getEmployee());
        
            List<Person> employee = company1.getEmployee();
            employee.forEach(System.out::println);
        
            
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
        }
    
    
    }
    
    
    public static void takeSomeTelefonBookEntry(TelefonBookEntry telefonBookEntry)
    {
    
    
    }
}
