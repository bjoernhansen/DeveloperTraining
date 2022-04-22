package com.concurrency.threads;

public class JoinTest extends Thread
{
    int a = 0;

    @Override
    public void run()
    {
        a++;
    }

    public static void main(String[] args)
    {       
        try
        {
            JoinTest test = new JoinTest();
            test.start();
            test.join();    // Hält den aufrufenden Thread, oft der Hauptthread, an
            System.out.println(test.a);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
