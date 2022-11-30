package training.concurrency.scheduledExecutorTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App
{
    public static void main(String[] args) {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(App::myTask, 5, 1, TimeUnit.SECONDS);
    }
    
    private static void myTask() {
        System.out.println("Running");
    }
}