package training.concurrency.clientServer1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public Server() throws IOException
    {
        @SuppressWarnings("resource")
        ServerSocket serverSocket = new ServerSocket(1234);
        
        while(true)
        {
            Socket clientSocket = serverSocket.accept();
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            
            int a = in.read();
            int b = in.read();
            
            out.write(a + b); // zum Client zurückschreiben
        }       
    }

    public static void main(String[] args)
    {        
        try
        {
            new Server();
        }
        catch (IOException e)
        {           
            e.printStackTrace();
        }        
    }
}
