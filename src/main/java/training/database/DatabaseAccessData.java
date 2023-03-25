package training.database;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public final class DatabaseAccessData
{
    public final static String
        PROPERTY_PATH = "/properties/db.properties";
    
    
    public final static String
        URL;
    
    public final static String
        DEFAULT_DATABASE;
    
    public final static String
        CIMDATA_DATABASE;
    
    public final static String
        USER;
    
    public final static String
        PASSWORD;
    
    public static final String
        PREFERRED_TABLE;
    
    
    static
    {
        //statischer "Konstruktor" (wird beim Laden der Klasse aufegrufen)
        Properties properties = new Properties();
        
        try(
            InputStream resourceAsStream = DatabaseAccessData.class.getResourceAsStream(PROPERTY_PATH);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(Objects.requireNonNull(resourceAsStream)))
        {
            properties.load(bufferedInputStream);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    
        URL = (String)  properties.get("url");
        DEFAULT_DATABASE = (String)  properties.get("default_database");
        CIMDATA_DATABASE = (String) properties.get("cimdata_database");
        USER = (String)  properties.get("user");
        PASSWORD = (String)  properties.get("password");
        PREFERRED_TABLE = (String)  properties.get("preferred_table");
    }
    
    private DatabaseAccessData()
    {
        throw new UnsupportedOperationException();
    }
}
