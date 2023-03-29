package training.database.jooq;

import org.jooq.codegen.GenerationTool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;


public class UsageOfJooq
{
    public static void main(String[] args)
    {
        try
        {
            InputStream resourceAsStream = UsageOfJooq.class.getClassLoader()
                                                            .getResourceAsStream("xml/jooq-config.xml");
            String jooqConfiqAsString = new BufferedReader(new InputStreamReader(resourceAsStream))
                .lines()
                .collect(Collectors.joining("\n"));
            
            GenerationTool.generate(jooqConfiqAsString);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        
/*        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);)
        {
    
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        
        
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }*/
    }
    
    private String fromUrlOf2(String path)
    {
        return Objects.requireNonNull(getClass().getResource(path))
                      .toString()
                      .replace("file:/", "");
    }
    
    
    private static String fromUrlOf(String path)
    {
        return (new UsageOfJooq().fromUrlOf2(path));
    }
    
}
