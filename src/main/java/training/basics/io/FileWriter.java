package training.basics.io;

import java.io.File;
import java.io.IOException;


public class FileWriter
{
    private static final String
        DIRECTORY_PATH = "logs/text_output/";
    
    private static final String
        TEXT_PATH = DIRECTORY_PATH + "test.txt";
    
    
    public static void main(String[] args)
    {
        createParentDirectoriesIfMissing();
        
        System.out.println("write...");
        
        try
        {
            java.io.FileWriter fw = new java.io.FileWriter(TEXT_PATH);
            fw.write("Hallo\n guten Tag...");
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private static void createParentDirectoriesIfMissing()
    {
        new File(DIRECTORY_PATH).mkdirs();
    }
}
