package training.concurrency.notifications;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class AlertingThreadPoolExecutor extends ThreadPoolExecutor
{
    CallbackInterface callback;

    public AlertingThreadPoolExecutor(CallbackInterface callback)
    {
        super(1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        this.callback = callback;
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t)
    {
        super.afterExecute(r, t);
        callback.taskDone("runnable details here");
    }
}
