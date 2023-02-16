package training.utilities.xml.persistenz.standard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class StandardSerializer
{
    private static final String
        FILE_PATH = "logs/person.dat";
    
    public static void main(String[] args) {
        writeObject(FILE_PATH, new Person("Max", new Adresse("Erkner")));
        
        Person p = (Person) readObject(FILE_PATH);
        System.out.println(p.getAdresse().getOrt());
        System.out.println(p.getAdresse().getOrtbeispiele()[0]);
    }
    
    public static void writeObject(String filename, Object obj)
    {
        OutputStream fos = null;
        try
        {
            fos = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(fos);
            o.writeObject(obj);
        } catch(IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                fos.close();
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static Object readObject(String filename)
    {
        InputStream fis = null;
        Object obj = null;
        
        try
        {
            fis = new FileInputStream(filename);
            ObjectInputStream o = new ObjectInputStream(fis);
            obj = o.readObject();
        } catch(IOException | ClassNotFoundException e)
        {
            System.err.println(e);
        } finally
        {
            try
            {
                fis.close();
            } catch(Exception ignored)
            {
            }
        }
        return obj;
    }
}
