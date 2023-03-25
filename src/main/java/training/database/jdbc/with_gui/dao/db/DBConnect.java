package training.database.jdbc.with_gui.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static training.database.DatabaseAccessData.CIMDATA_DATABASE;
import static training.database.DatabaseAccessData.PASSWORD;
import static training.database.DatabaseAccessData.URL;
import static training.database.DatabaseAccessData.USER;


public final class DBConnect
{
    
    private static DBConnect instance = null;
    
    private Connection con;
    
    
    private DBConnect()
    {
        try
        {
            con = DriverManager.getConnection(URL + CIMDATA_DATABASE, USER, PASSWORD);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public static DBConnect getInstance()
    {
        if(instance == null)
        {
            instance = new DBConnect();
        }
        return instance;
    }
    
    public Connection getConnection()
    {
        return con;
    }
}
