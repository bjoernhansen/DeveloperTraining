package com.concurrency.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class MyRemoteImplementation extends UnicastRemoteObject implements MyRemote
{
    @Override
    public String sayHello() throws RemoteException
    {
        return "Der Server sagt: 'Moin!'";
    }
    
    protected MyRemoteImplementation() throws RemoteException
    {
    
    }
    
    public static void main(String[] args)
    {
        try
        {
            String name = "RemoteHello";
            
            // Ersetzt das Starten von rmiregistry über das Terminal
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT); //Port binden
            
            MyRemote service = new MyRemoteImplementation();
            Naming.rebind(name, service);
            
            // Alternative
            /*
            MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            */
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
