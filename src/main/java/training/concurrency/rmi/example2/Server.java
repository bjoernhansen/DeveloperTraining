package training.concurrency.rmi.example2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;


public class Server
{
    public static void main(String[] args)
    {
        // Logger von RMI umlenken zu Standardausgabe
        RemoteServer.setLog(System.out);
        
        Adder adder = new Adder();
        
        try
        {
            // Remote-Objekt exportieren
            IAdder uro = (IAdder) UnicastRemoteObject.exportObject(adder, 0);
            
            // registrieren (Standardport: 1099)
            Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            reg.rebind("Adder1", uro); // Alternative: bind (aber Exception möglich, wenn schon gebunden)
            System.out.println("Adder registiert");
        }
        catch(RemoteException e)
        {
            e.printStackTrace();
        }
    }
}
