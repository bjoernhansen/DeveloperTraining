package training.concurrency.notifications;

class Task implements Runnable
{
    private String result = "empty";

    @Override
    public void run()
    {
        System.out.println("Task in progress");
        sleep(2000);
        result = "finished";
    }

    static void sleep(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String getResult()
    {
        return result;
    }
}