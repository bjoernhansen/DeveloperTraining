package training.concurrency.rmi.example2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            //	Registry reg  = LocateRegistry.getRegistry("loclahost",Registry.REGISTRY_PORT);
            Registry reg = LocateRegistry.getRegistry();// standard zum testen lokal
            
            IAdder adder = (IAdder) reg.lookup("Adder1"); // aus der Registry Objekt mit Schlüssel (Server bind/rebind) holen
            
            System.out.println(adder.add(23, 2));
        }
        catch(RemoteException | NotBoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
