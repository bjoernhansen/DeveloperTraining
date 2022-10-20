package com.utilities.database.connect;

import java.sql.Connection;

public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		DBConnect dbc = DBConnect.getInstance();
		Connection con = dbc.getCon();
	}
}
