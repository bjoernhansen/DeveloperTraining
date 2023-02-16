package training.concurrency.rmi.example2;

import java.rmi.RemoteException;


public class Adder implements IAdder
{
    @Override
    public int add(int a, int b) throws RemoteException
    {
        return a + b;
    }
}
