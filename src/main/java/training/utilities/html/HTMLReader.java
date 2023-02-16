package training.utilities.html;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HTMLReader
{
    public static final String REGEX_HYPERLINK = "\\b(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    
    public static String readHTML(String urlString) throws IOException
    {
        URL url = new URL(urlString);
        System.out.println(urlString);
        StringBuilder sb = new StringBuilder();
        try(Scanner sc = new Scanner(url.openStream()))
        {// AutoClose
            while(sc.hasNext())
            {
                sb.append(sc.nextLine())
                  .append("\n");
            }
        }
        return sb.toString();
    }
    
    public static List<String> findLinks(String source)
    {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_HYPERLINK, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(source);
        while(matcher.find())
        {
            result.add(matcher.group()); // gibt jeweils den gefundenen
            // String zurück
            //System.out.println(matcher.group() );
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        try
        {
            // System.out.println(readHTML("http://google.de"));
            
            String source = readHTML("http://google.de");
            List<String> links = findLinks(source);
            System.out.println("Links:");
            links.forEach(System.out::println);
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

