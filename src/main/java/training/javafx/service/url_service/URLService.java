package training.javafx.service.url_service;

import java.net.URL;
import java.util.Scanner;

import javafx.concurrent.Service;
import javafx.concurrent.Task;


public class URLService extends Service <String>
{
	private URL url;
	
	@Override
	protected Task<String> createTask()
	{
		Task<String> task = new Task<String>()
		{			
			@Override
			protected String call() throws Exception
			{				
			    //System.setProperty("java.net.useSystemProxies", "true");
			    updateMessage("start reading URL content");
			    StringBuilder sb = new StringBuilder();
				
				Scanner sc = new Scanner(url.openStream());
				
				int i = 0;
				while(sc.hasNext() )
				{					
				    i++;				   
				    updateMessage("processed lines: " + i);				   
				    sb.append(sc.nextLine());
				    sb.append(System.getProperty("line.separator"));
				}
				updateMessage("finished reading URL content");				
				sc.close();
				return sb.toString();
			}
		};		
		return task;
	}

	public URL getUrl() 
	{
		return url;
	}

	public void setUrl(URL url)
	{
		this.url = url;
	}
}
