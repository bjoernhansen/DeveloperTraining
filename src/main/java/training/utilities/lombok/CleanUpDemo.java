package training.utilities.lombok;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.IOException;

public class CleanUpDemo
{
    private static final String
        TEXT_PATH = "src/main/resources/text/test.txt";
    
    
    public static void main(String[] args) throws IOException
    {
        readFile(TEXT_PATH);
    }
    
    private static void readFile(String filePath) throws IOException {
        @Cleanup FileInputStream fileInputStream = new FileInputStream(filePath); // this annotation works by harnessing the try-with-resources statement
        int data = fileInputStream.read();
        while(data != -1) {
            System.out.print((char) data);
            data = fileInputStream.read();
        }
    }
}