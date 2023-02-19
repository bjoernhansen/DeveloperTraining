package training.basics.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


public class Reader
{
    public static final String
        TEXT_PATH_1 = "src/main/resources/text/test.txt";
    
    public static final String
        TEXT_PATH_2 = "/text/test.txt";
    
    public static void main(String[] args)
    {
        try
        {
            new Reader().read();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void read() throws IOException
    {
        File file = new File(TEXT_PATH_1);
        System.out.println(file.exists());
        String absolutePath = file.toPath()
                                  .toAbsolutePath()
                                  .toString();
        System.out.println(absolutePath);
        
        InputStream inputStream = getClass().getResourceAsStream(TEXT_PATH_2);
        
        InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
    
        System.out.println();
        for(String line; (line = reader.readLine()) != null; )
        {
            System.out.println(line);
        }
        
        inputStream.close();
    }
}
