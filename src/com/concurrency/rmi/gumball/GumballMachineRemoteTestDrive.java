package com.concurrency.rmi.gumball;

import com.concurrency.rmi.gumball.machine.GumballMachineImplementation;
import com.concurrency.rmi.gumball.machine.GumballMachineRemote;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GumballMachineRemoteTestDrive
{
    private static final String
        NAME = "gumballmachine";
    
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }
        
        try
        {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT); //Port binden
            int count = Integer.parseInt(args[1]);
            GumballMachineRemote gumballMachine = new GumballMachineImplementation(args[0], count);
            Naming.rebind(NAME, gumballMachine);
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
