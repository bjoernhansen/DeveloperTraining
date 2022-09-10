package com.concurrency.clientServer2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            System.out.println("Server.accept...");
            go(clientSocket);
                
        }      
        // serverSocket.close();
    }

    private void go(Socket clientSocket)
    {
        new Thread( ()-> 
        {
           try 
           {
               // Achtung! auf Client-Seite andere Reihenfolge der Objekterzeugung
               // nur für ein serialisierbares Object möglich
               ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
               String text = String.valueOf(in.readObject());
               
               ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
               out.writeObject(text.toLowerCase()); // zum Client zurückschreiben
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }            
        }).start();      
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
