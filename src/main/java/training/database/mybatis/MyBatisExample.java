package training.database.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisExample
{
    public static final String RESOURCE = "xml/mybatis/mybatis-config.xml";
    
    public static void main(String[] args)
    {
        try(InputStream inputStream = Resources.getResourceAsStream(RESOURCE))
        {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            
            try (SqlSession session = sqlSessionFactory.openSession()) {
    
                System.out.println("\nFull names of customers:");
                CustomerMapper mapper = session.getMapper(CustomerMapper.class);
                mapper.selectAll().forEach(MyBatisExample::printFullNameWithId);
    
                System.out.println("\nList of order items:");
                OrderItemsMapper orderItemsMapper = session.getMapper(OrderItemsMapper.class);
                orderItemsMapper.selectAll().forEach(System.out::println);
            }
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    private static void printFullNameWithId(Customer customer)
    {
        System.out.println( customer.getFirstName() + " " +
                            customer.getLastName() + "(" +
                            customer.getCustomerIdentification() + ")");
    }
}
