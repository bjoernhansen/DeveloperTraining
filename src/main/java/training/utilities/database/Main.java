package training.utilities.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Java Program to to connect to MySQL database and
 * fix java.sql.SQLException: No suitable driver found
 * for jdbc:mysql://localhost:3306
 * error which occur if JAR is missing or you fail to register driver.
 */

public class Main
{
    public static void main(String[] args)
    {
        Connection dbConnection;
        
        Connection conn = null;
        try
        {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/my_database";
            String user = "root";
            String password = "Zeratul4799!";
            
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            try
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        
        /*
        try {
            String url = "jdbc:mysql://localhost:3306/my_database";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Zeratul4799!");
            
            dbConnection = DriverManager.getConnection(url, info);
            
            if (dbConnection != null) {
                System.out.println("Successfully connected to MySQL database test");
            }
            
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }
        */
        
    }
    
}