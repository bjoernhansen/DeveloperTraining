package training.utilities.gson.from_file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersonDAO
{
    public static final String JSON_FILE = "src/main/resources/json/personen.json"; // check format at https://jsonlint.com/
    
    public void savePerson(Person person)
    {
        List<Person> list = readJson();
        list.add(person);
        writeJson(list);
    }
    
    public List<Person> findAll()
    {
        return readJson();
    }
    
    private void writeJson(Object obj)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                                     .create();
        try
        {
            Type type = new TypeToken<List<Person>>()
            {
            }.getType();
            String json = gson.toJson(obj, type);
            
            Files.write(Paths.get(JSON_FILE), json.getBytes(), StandardOpenOption.CREATE);
            
        } catch(JsonIOException | IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    private List<Person> readJson()
    {
        try(Reader reader = new InputStreamReader(new FileInputStream(JSON_FILE), StandardCharsets.UTF_8))
        {
            Gson gson = new GsonBuilder().create();
            
            Type type = new TypeToken<List<Person>>()
            {
            }.getType();
            
            return gson.fromJson(reader, type); // List<Person>
            
            // return getTestPersonsList();
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}