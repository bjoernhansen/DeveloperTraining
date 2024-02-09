package training.concurrency;

import static training.concurrency.WorkingWithThreads.DISTANCE;

public class CustomThread extends Thread {
    private final int threadNumber;
    private final VariableNumber counter;


    private boolean isPausable = true;
    private final Range rangeOfResponsibility;


    CustomThread(int threadNumber, VariableNumber counter, int first, int last)
    {
        this.threadNumber = threadNumber;
        this.counter = counter;
        this.rangeOfResponsibility = Range.of(first, last);
    }

    @Override
    public void run()
    {
        System.out.println("Starte Thread Nr. " + threadNumber);
        while(!rangeOfResponsibility.isBelow(counter.getValue()))
        {
            synchronized(counter)
            {
                if(rangeOfResponsibility.contains(counter.getValue()))
                {
                        System.out.printf("%d -> %d by thread %d%n", counter.getValue(), counter.getAndIncrement(), threadNumber);
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