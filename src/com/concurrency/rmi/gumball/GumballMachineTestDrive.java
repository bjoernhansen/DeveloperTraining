package com.concurrency.rmi.gumball;

import com.concurrency.rmi.gumball.machine.GumballMachine;
import com.concurrency.rmi.gumball.machine.GumballMachineImplementation;
import com.concurrency.rmi.gumball.machine.GumballMachineRemote;
import com.concurrency.rmi.gumball.machine.GumballMonitor;

import java.rmi.RemoteException;

public class GumballMachineTestDrive
{
    
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Kaugummiautomat <name> <inventory>");
            System.exit(0);
        }
        
        try
        {
            int count = Integer.parseInt(args[1]);
            
            GumballMachine gumballMachine = new GumballMachineImplementation(args[0], count);
            
            gumballMachine.insertQuarter();
            gumballMachine.ejectQuarter();
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
    
            System.out.println(gumballMachine);
            
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            
            gumballMachine.refill(5);
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            
            System.out.println(gumballMachine);
        } catch (NumberFormatException | RemoteException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
