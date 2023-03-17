package training.database.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import training.database.jdbc.JdbcExample;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static training.database.DatabaseAccessData.PASSWORD;
import static training.database.DatabaseAccessData.URL;
import static training.database.DatabaseAccessData.USER;


public class UsageOfHikariCP
{
    public static void main(String[] args) throws SQLException
    {
        DataSource dataSource = createDataSource();
        
        try(Connection conn = dataSource.getConnection())
        {
            // "0" means disabling the timeout, when doing isValid checks
            boolean isValid = conn.isValid(0);
            System.out.println("Do we have a valid db connection? = " + isValid);
            
            // Do something with the Connection, run some SQL statements
            
            JdbcExample.printOutCustomers(conn);
        }
    }
    
    private static DataSource createDataSource()
    {
        HikariDataSource dc = new HikariDataSource();
        dc.setJdbcUrl(URL);
        dc.setUsername(USER);
        dc.setPassword(PASSWORD);
        return dc;
    }
}