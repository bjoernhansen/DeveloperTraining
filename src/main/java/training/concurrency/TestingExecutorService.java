package training.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


class TestingExecutorService
{
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.invokeAll(List.of(TestingExecutorService::getStringDelayed,
                                          TestingExecutorService::getStringDelayed,
                                          TestingExecutorService::getStringDelayed));
        executorService.shutdown();
        if(!executorService.awaitTermination(3, TimeUnit.SECONDS))
        {
            executorService.shutdownNow();
        }
    }
    
    private static String getStringDelayed()
    {
        int durationInMs = ThreadLocalRandom.current()
                                            .nextInt(5000);
        tryToSleep(durationInMs);
        String output = "a string after " + durationInMs + " ms";
        System.out.println(output);
        return output;
    }
    
    private static void tryToSleep(int durationInMs)
    {
        try
        {
            Thread.sleep(durationInMs);
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
