package training.database.jdbc.with_gui.generic_db.db;

/**
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static training.database.DatabaseAccessData.DEFAULT_DATABASE;
import static training.database.DatabaseAccessData.PASSWORD;
import static training.database.DatabaseAccessData.URL;
import static training.database.DatabaseAccessData.USER;

/**
 *
 * Java 2(cimdata)
 * @author Dozent Michael Schirmer
 * micha.schirmer@gmail.com
 * db.DBConnect.java
 */
public class DBConnect
{
    //static reference to itself
    private static final DBConnect instance = new DBConnect();

    
    
    //private constructor
    private DBConnect()
    {
    }
    
    private Connection createConnection()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(URL + DEFAULT_DATABASE, USER, PASSWORD);
        }
        catch(SQLException e)
        {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }
    
    /**
     * @see java.sql.DriverManager
     * @return Connection
     */
    public static Connection getConnection()
    {
        return instance.createConnection();
    }
}