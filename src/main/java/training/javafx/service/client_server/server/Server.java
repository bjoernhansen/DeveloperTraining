package training.javafx.service.client_server.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class Server extends Service <String>
{   
    ServerSocket serverSocket;
        
    @Override
    protected Task<String> createTask()
    {
        return new Task<>()
        {
            @Override
            protected String call()
            {
                System.out.println("server started");
                updateMessage("server started");
                String clientText = "";
                try
                {
                    while(true)
                    {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("Server accept...");
                        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                        clientText = String.valueOf(in.readObject());
                        System.out.println("Empfangener Text: " + clientText);
                        updateValue(clientText);
                    }
                } catch(Exception e)
                {
                    e.printStackTrace();
                }
                return clientText;
            }
        };
    }
    
    public void setServerSocket(int portNumber)
    {        
        try
        {
            this.serverSocket = new ServerSocket(portNumber);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
