package com.concurrency.rmi.gumball;

import com.concurrency.rmi.gumball.machine.GumballMachineRemote;
import com.concurrency.rmi.gumball.machine.GumballMonitor;

import java.rmi.Naming;

public class GumballMonitorTestDrive
{
    private static final String
        NAME = "gumballmachine";
    
    public static void main(String[] args)
    {
        String location = "rmi://127.0.0.1/" + NAME;
        
        try
        {
            GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location);
            GumballMonitor monitor = new GumballMonitor(machine);
            monitor.report();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
