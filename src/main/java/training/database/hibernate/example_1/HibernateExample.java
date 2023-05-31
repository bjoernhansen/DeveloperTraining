package training.database.hibernate.example_1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;


public class HibernateExample
{
    public static void main(String[] args)
    {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
        
        try(EntityManagerFactory sessionFactory = new MetadataSources(registry).buildMetadata()
                                                                               .buildSessionFactory();
            EntityManager session = sessionFactory.createEntityManager();)
        {
            Customer newCustomer = new Customer("Kurt", "Schlauberger", "Birkenstraße 17", "München", "UC", 12);
            // TODO customer speichern
            
            System.out.println("Session was committed: " + wasCommitted(session));
            
            session.getTransaction()
                   .begin();
            
            List<Customer> customers = session.createQuery("select u from Customer u", Customer.class)
                                              .getResultList();
            customers.forEach(System.out::println);
            
            List<Order> orders = session.createQuery("select u from Order u", Order.class)
                                        .getResultList();
            orders.forEach(System.out::println);
            
            session.getTransaction()
                   .commit();
            
            
        }
        catch(Exception e)
        {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            // transaction.rollback();
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println("SCHITT");
        }
        
        // Here we tell Hibernate that we annotated our User class
        /*MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(Customers.class);
        Metadata metadata = metadataSources.buildMetadata();*/
    }
    
    private static boolean wasCommitted(EntityManager session)
    {
        return ((Session) session).getTransaction()
                                  .getStatus() == TransactionStatus.COMMITTED;
    }
}
