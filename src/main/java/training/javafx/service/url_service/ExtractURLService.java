package training.javafx.service.url_service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.concurrent.Service;
import javafx.concurrent.Task;


public class ExtractURLService extends Service <String>
{
    private static final String
        urlPattern = "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
            + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
            + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)";
        
    String urlText;    
    //private List<String> urlList = new ArrayList<String>(); // TODO <List<String>> muss es sein
    
    
    @Override
    protected Task<String> createTask()
    {
        return new Task<>()
        {
            @Override
            protected String call()
            {
                updateMessage("Start extracting URLs");
                StringBuilder sb = new StringBuilder();
    
                Pattern p = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
                Matcher m = p.matcher(urlText);
    
                int i = 0;
                while(m.find())
                {
                    i++;
                    updateMessage("processed URLs: " + i);
                    sb.append(urlText, m.start(0), m.end(0));
                    sb.append(System.getProperty("line.separator"));
                }
                updateMessage("finished extracting URLs");
                return sb.toString();
            }
        };
    }
    
    public void setUrlText(String text)
    {
        this.urlText = text;
    }
}
