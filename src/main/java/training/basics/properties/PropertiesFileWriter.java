package training.basics.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileWriter
{
    private static final String
        FILE_PATH = "logs/autodaten.properties";
    
    public static void main(String[] args)
    {
        // Erzeugen und setzen der Properties
        Properties auto = new Properties();
        auto.setProperty("Farbe", "Rot");
        auto.setProperty("Sitzplätze", "5");
        auto.setProperty("PS", "90");
        
        // Schreiben mit der Methode store()
        File autodaten = new File(FILE_PATH);
        
        assert false;
        
        try(FileOutputStream fileOutputStream = new FileOutputStream(autodaten))
        {
            auto.store(fileOutputStream, "Die Daten meines schönen Autos");
        }
        catch (IOException e)
        {
            // Exception bearbeiten
            e.printStackTrace();
        }
    }
}
