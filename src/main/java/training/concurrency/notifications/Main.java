package training.concurrency.notifications;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class Main
{
    public static void main(String[] args)
    {
        // useCompletableFuture();

        // usingThreadPoolExecutor();

        useExtensionOfFutureTask();

        Task.sleep(3500);
    }

    private static void usingThreadPoolExecutor()
    {
        AlertingThreadPoolExecutor alertingThreadPoolExecutor = new AlertingThreadPoolExecutor(new Callback());
        alertingThreadPoolExecutor.afterExecute(new Task(), null);
    }

    private static void useCompletableFuture()
    {
        Task task = new Task();
        Callback callback = new Callback();

        CompletableFuture.runAsync(task)
                         .thenAccept(result -> callback.taskDone("completion details: " + task.getResult()));
    }

    private static void useExtensionOfFutureTask()
    {
        Task task = new Task();
        Callback callback = new Callback();

        FutureTask<String> future = new AlertingFutureTask(task, callback);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(future);
    }
}
