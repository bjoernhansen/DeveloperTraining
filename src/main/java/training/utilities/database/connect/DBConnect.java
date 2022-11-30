package training.utilities.database.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DBConnect als Singleton
 */

public class DBConnect 
{
	public static DBConnect dbConnectObject = new DBConnect();
	
	private Connection con;	
	
	
	public DBConnect() 
	{
		try 
		{		
			this.con = DriverManager.getConnection("jdbc:mysql:3306/my_database", "root", "Zeratul4799!");
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
	}		
	
	public static DBConnect getInstance()
	{
		return dbConnectObject;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
