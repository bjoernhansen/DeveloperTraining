package training.utilities.lombok;

public class LombokTrial
{
    public static void main(String[] args)
    {
        User user = new User("Kurt", "Müller");
        System.out.println(user.getId());
        
        User user2 = new User(12L, "Klaus", "Meier", 12);
        
        System.out.println(user2);
        
        Employee employee = Employee.builder()
                                    .id(13)
                                    .firstName("Hillary")
                                    .lastName("Clinton")
                                    .build();
    
        System.out.println(employee);
        
        employee.logTrial();
        System.out.println("Reports: " + employee.getReports());
    
        Customer customer = new Customer();
        customer.setFirstName("Michael");
        System.out.println(customer.getFirstName());
    }
}
