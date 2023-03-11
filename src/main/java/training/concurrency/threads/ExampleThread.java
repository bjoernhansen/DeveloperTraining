package training.concurrency.threads;

public class ExampleThread extends Thread
{
    private final String name;
    
    private final NonAtomicInteger value;
    
    public ExampleThread(String threadName, NonAtomicInteger value)
    {
        this.name = threadName;
        this.value = value;
    }
    
    @Override
    public void run()
    {
        System.out.println("Start " + name);
        System.out.println("Finish " + name);
    }
    
    public static void main(String[] args)
    {
        NonAtomicInteger value = new NonAtomicInteger();
        
        
        Thread t1 = new ExampleThread("Thread 1", value);
        Thread t2 = new ExampleThread("Thread 2", value);
        
        t1.start();
        t2.start();
        
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
        
        private synchronized void increment()
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
