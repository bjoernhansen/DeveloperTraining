package training.javafx.service.client_server.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.concurrent.Service;
import javafx.concurrent.Task;


public class Client extends Service <String>
{    
    String text = "";    

    @Override
    protected Task<String> createTask()
    {
        return new Task<>()
        {
            @Override
            protected String call()
            {
                Socket socket;
                try
                {
                    socket = new Socket("localhost", 1234);
                    updateMessage("sending message to server");
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(text);
                    socket.close();
                } catch(IOException e)
                {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }

    public void setText(String text)
    {
        this.text = text;        
    }    
}