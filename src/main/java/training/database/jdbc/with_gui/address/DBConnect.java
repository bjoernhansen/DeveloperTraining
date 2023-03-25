package training.database.jdbc.with_gui.address;

import training.database.DatabaseAccessData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnect
{
    // TODO die 3 Beispiel unter jdbc/with_gui/address zusammen führen
    private static DBConnect instance = null;
    private final Connection con;
    
    private DBConnect() throws DBConnectException
    {
        try
        {
            this.con = DriverManager.getConnection(
                DatabaseAccessData.URL + DatabaseAccessData.CIMDATA_DATABASE,
                DatabaseAccessData.USER,
                DatabaseAccessData.PASSWORD);
        }
        catch(SQLException e)
        {
            //TODO log.error
            throw new DBConnectException();
        }
    }
    
    public static DBConnect getInstance() throws DBConnectException
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
