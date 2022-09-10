package com.concurrency.clientServer2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    private static final String TEST_STRING = "HallO, IcH BIn DeIN oHrwUrm!";
    
    public Client() throws UnknownHostException, IOException, ClassNotFoundException
    {
        Socket serverSocket = new Socket("localhost", 1234);
        
        // Reihenfolge der Objekterzeugung beachten
        System.out.println("Client: Sende an Server \"" + TEST_STRING + "\"");
        ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
        out.writeObject(TEST_STRING);
                
        //Antwort vom Server
        ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
        System.out.println("Client: Erhalte vom Server \"" + in.readObject() + "\"\n");
        serverSocket.close();
    }
    
    

    public static void main(String[] args)
    {
        try
        {
            new Client();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
