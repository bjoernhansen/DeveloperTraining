package com.utilities.database;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnection
{
    private static final String URL = "jdbc:mysql://localhost/3306/";
    private String user = "root";
    private String password = "Zeratul4799!";
    private String db = "my_database";
    private String command;
    
    
    public DBConnection(String text)
    {
        // this.setCommand("");
    }
    
    
    public static void main(String[] args)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Connection con = DriverManager.getConnection(URL,  )
            
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}