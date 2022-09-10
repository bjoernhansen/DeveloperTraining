package com.concurrency.clientServer1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    public Client() throws IOException
    {
        Socket serverSocket = new Socket("localhost", 1234);
        OutputStream out = serverSocket.getOutputStream();
        out.write(6);
        out.write(3);
        
        //Antwort vom Server
        InputStream in = serverSocket.getInputStream();
        System.out.println("Client: " + in.read());
        serverSocket.close();
    }
    
    

    public static void main(String[] args)
    {
        try
        {
            new Client();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
