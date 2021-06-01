package com.concurrency;

import static com.concurrency.Main.DISTANCE;

public class CustomThread extends Thread {
    private int threadNumber;
    private final VariableNumber counter;


    private boolean isPausable = true;
    private Range rangeOfResponsibility;


    CustomThread(int threadNumber, VariableNumber counter, int first, int last)
    {
        this.threadNumber = threadNumber;
        this.counter = counter;
        this.rangeOfResponsibility = Range.of(first, last);
    }

    public void run()
    {
        System.out.println("Starte Thread Nr. " + threadNumber);
        while(!rangeOfResponsibility.isBelow(counter.getValue()))
        {
            synchronized(counter)
            {
                if(rangeOfResponsibility.contains(counter.getValue()))
                {
                        System.out.println(String.format("%d -> %d by thread %d", counter.getValue(), counter.getAndIncrement(), threadNumber));
                        counter.notifyAll();
                }
                try
                {
                    if(isPausable || rangeOfResponsibility.contains(counter.getValue() + DISTANCE))
                    {
                        System.out.println("Pausiere Thread Nr. " + threadNumber);
                        counter.wait();
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Beende Thread Nr. " + threadNumber);
    }

    Range getRangeOfResponsibility() {
        return rangeOfResponsibility;
    }

    void setUnpausable() {
        isPausable = false;
    }
}