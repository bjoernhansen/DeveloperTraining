package training.java_basics.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTrial
{
    private static final String
        FOLDER_PATH = "src/com/java_basics/properties/",
        FILE_NAME = "autodaten.properties";
    
    public static void main(String[] args)
    {
        String filePath = FOLDER_PATH + FILE_NAME;
        
        // Erzeugen und setzen der Properties
        Properties auto = new Properties();
        auto.setProperty("Farbe", "Rot");
        auto.setProperty("Sitzplätze", "5");
        auto.setProperty("PS", "90");
        
        // Schreiben mit der Methode store()
        File autodaten = new File(filePath);
        
        assert false;
        
        try(FileOutputStream fileOutputStream = new FileOutputStream(autodaten))
        {
            auto.store(fileOutputStream, "Die Daten meines Autos");
        }
        catch (IOException e)
        {
            // Exception bearbeiten
        }
    }
}
