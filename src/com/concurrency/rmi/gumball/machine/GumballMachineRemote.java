package com.concurrency.rmi.gumball.machine;

import com.concurrency.rmi.gumball.machine.state.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote
{
    int getCount() throws RemoteException;
    
    String getLocation() throws RemoteException;
    
    State getState() throws RemoteException;
}
