package training.database.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
            session.getTransaction().begin();
            
            List<Customer> customers = session.createQuery("select u from Customer u", Customer.class)
                                                         .getResultList();
            
            customers.forEach(System.out::println);
            
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
        
        
        // Here we tell Hibernate that we annotated our User class
        /*MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(Customers.class);
        Metadata metadata = metadataSources.buildMetadata();*/
        
    }
}
