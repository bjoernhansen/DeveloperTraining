package training.utilities.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest
{
	public static void main(String[] args)
	{
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/3306", "root", "");
			show(con);			
			
			Statement insertStatement = con.createStatement();
			insertStatement.executeUpdate("INSERT INTO designpattern (name, beschreibung) VALUES ('DAO', 'Data Access Object kapselt DB-Zugriff')");
			show(con);	
			
			Statement deleteStatement = con.createStatement();
			deleteStatement.executeUpdate("DELETE FROM designpattern WHERE name = 'DAO'");
			show(con);
						
			PreparedStatement updateStatement = con.prepareStatement("UPDATE designpattern SET beschreibung=? WHERE id=?");
			updateStatement.setString(1, "Stellt eine Instanz sicher!"); // erstes Fragezeichen
			updateStatement.setInt(2, 1); //zweites Fragezeichen
			updateStatement.executeUpdate();			
			show(con);		
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
	}

	private static void show(Connection con) throws SQLException
	{
		Statement selectAllStatement = con.createStatement();
		ResultSet rs = selectAllStatement.executeQuery("SELECT * FROM designpattern");
		System.out.println("----------------------------------");
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String beschreibe = rs.getString("beschreibung"); 
		
			System.out.printf("%d %s \t\t %s\n", id, name, beschreibe);
		}
	}
}