package training.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static training.database.DatabaseAccessData.PASSWORD;
import static training.database.DatabaseAccessData.URL;
import static training.database.DatabaseAccessData.USER;

/*
 * Java Program to connect to MySQL database and
 * fix java.sql.SQLException: No suitable driver found
 * for jdbc:mysql://localhost:3306
 * error which occur if JAR is missing or you fail to register driver.
 */

public class JdbcExample
{
    public static void main(String[] args)
    {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);)
        {
            // "0" means disabling the timeout, when doing isValid checks
            boolean isValid = connection.isValid(0);
            System.out.println("Do we have a valid db connection? = " + isValid);
    
            printOutCustomers(connection);
    
            // Insert
            Statement insertStatement = connection.createStatement();
            insertStatement.executeUpdate(
                "INSERT INTO customers(last_name, first_name, address, city, state, points) " +
                    "VALUES('Meyer','Klaus','Some street','SomeCity','VA','123')");
            printOutCustomers(connection);
    
            // Update
            PreparedStatement updateStatement1 = connection.prepareStatement("UPDATE customers SET last_name=? WHERE customer_id > ?");
            updateStatement1.setString(1, "Hansen"); // erstes Fragezeichen
            updateStatement1.setInt(2, 10); //zweites Fragezeichen
            updateStatement1.executeUpdate();
            printOutCustomers(connection);
            
            // Delete
            Statement deleteStatement = connection.createStatement();
            int numberOfDeletesRows = deleteStatement.executeUpdate("DELETE FROM customers WHERE customer_id > 10");
            printOutCustomers(connection);
            System.out.println("Deleted rows: " + numberOfDeletesRows);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    static void printOutCustomers(Connection connection) throws SQLException
    {
        Statement selectAllStatement = connection.createStatement();
        ResultSet rs = selectAllStatement.executeQuery("SELECT * FROM customers");
    
        System.out.println("----------------------------------");
        while(rs.next())
        {
            int id = rs.getInt("customer_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            System.out.printf("%d %s \t\t %s\n", id, firstName, lastName);
        }
    }
}
