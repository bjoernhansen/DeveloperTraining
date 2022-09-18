package com.concurrency.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote
{
    // Rückgabewerte müssen primitiv sein oder Serializable implementieren
    String sayHello() throws RemoteException;
}
