package training.basics.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader
{
    private static final String
        TEXT_PATH = "src/main/resources/text/test.txt";
   
    
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(new File(TEXT_PATH));
            while(sc.hasNext())
            {
                System.out.println(sc.nextLine());
            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
