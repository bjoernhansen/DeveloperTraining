package training.database;

public final class DatabaseAccessData
{
    final static String
        URL = "jdbc:mysql://localhost:3306/sql_store";
    
    final static String
        USER = "root";
    
    final static String
        PASSWORD = "secret";
    
    
    private DatabaseAccessData()
    {
        throw new UnsupportedOperationException();
    }
}
