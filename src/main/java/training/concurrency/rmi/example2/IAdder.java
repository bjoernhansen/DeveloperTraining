package training.concurrency.rmi.example2;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IAdder extends Remote
{
    int add(int a, int b) throws RemoteException;
}
