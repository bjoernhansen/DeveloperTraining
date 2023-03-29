package training.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Example
{
    public static void main(String[] args)
    {
        // jdbc:h2:mem: --> one in-memory database with no name
        // "jdbc:h2:mem:/database/h2_data"
        
        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:sql/design_pattern_for_h2.sql'"))
        {
            System.out.println("connection.isValid(0) = " + connection.isValid(0));
            printOutCustomers(connection);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    static void printOutCustomers(Connection connection) throws SQLException
    {
        Statement selectAllStatement = connection.createStatement();
        ResultSet rs = selectAllStatement.executeQuery("SELECT * FROM designpattern");
        
        System.out.println("----------------------------------");
        while(rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String beschreibung = rs.getString("beschreibung");
            System.out.printf("%d %s \t\t %s\n", id, name, beschreibung);
        }
    }
    
    
}
