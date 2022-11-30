package training.design_pattern.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnect {

	private static DBConnect instance = null;
	private Connection con;
	
	private  DBConnect() {
		try {
			con  = DriverManager.getConnection("jdbc:mysql://localhost/java2","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnect getInstance(){
		if(instance == null){
			instance = new DBConnect();
		}
		return instance;
	}
	
	public Connection getConnection(){
		return con;
	}
}
