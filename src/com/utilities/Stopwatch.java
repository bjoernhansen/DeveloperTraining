package com.utilities;

public class Stopwatch
{
    private final boolean
            useNanoTime = false;

    private long
            startTime = 0;

    boolean
            started = false;




    public void startClock()
    {
        startTime = useNanoTime ? System.nanoTime() : System.currentTimeMillis();
        started = true;
    }

    public void stopClock()
    {
        if(started)
        {
            long stopTime = useNanoTime ? System.nanoTime() : System.currentTimeMillis();
            System.out.println("Zeit: " + (stopTime - startTime));
            started = false;
        }
    }

    public static Stopwatch make()
    {
        return new Stopwatch();
    }
}
