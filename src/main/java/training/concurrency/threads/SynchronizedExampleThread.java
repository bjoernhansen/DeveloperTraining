package training.concurrency.threads;

public class SynchronizedExampleThread extends Thread
{
    public static final boolean SET_PRIORITY = false;
    
    private final NonAtomicInteger value;
    
    private final String name;
    
    private final int waitTimeInMs;
    
    public SynchronizedExampleThread(NonAtomicInteger value, String threadName, int waitTimeInMs)
    {
        this.value = value;
        this.name = threadName;
        this.waitTimeInMs = waitTimeInMs;
    }
    
    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            synchronized(value)
            {
                value.increment();
                System.out.println(value + " von " + name);
                try
                {
                    Thread.sleep(waitTimeInMs);
                }
                catch(InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Finish " + name);
    }
    
    public static void main(String[] args)
    {
        NonAtomicInteger value = new NonAtomicInteger();
        Thread t1 = new SynchronizedExampleThread(value, "Thread 1", 0);
        Thread t2 = new SynchronizedExampleThread(value, "Thread 2", 0);
        
        t1.start();
        t2.start();
    
        if(SET_PRIORITY)
        {
            t1.setPriority(Thread.MIN_PRIORITY);
            t2.setPriority(Thread.MAX_PRIORITY);
        }
        
        try
        {
            // jetzt wartet der Haupt-Thread bis die anderen beiden durchgelaufen sind
            t1.join();
            t2.join();
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    
        System.out.println("Hauptthread zu Ende");
    }
    
    
    private static class NonAtomicInteger
    {
        private int value = 0;
        
        private void increment()
        {
            value++;
        }
    
        @Override
        public String toString()
        {
            return Integer.toString(value);
        }
    }
    
}
