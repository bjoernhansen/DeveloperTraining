package training.database;

public final class DatabaseAccessData
{
    public final static String
        URL = "jdbc:mysql://localhost:3306/sql_store";
    
    public final static String
        USER = "root";
    
    public final static String
        PASSWORD = "secret";
    
    
    private DatabaseAccessData()
    {
        throw new UnsupportedOperationException();
    }
}
