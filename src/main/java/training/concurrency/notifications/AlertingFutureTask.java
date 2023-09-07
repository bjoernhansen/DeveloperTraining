package training.concurrency.notifications;

import java.util.concurrent.FutureTask;

class AlertingFutureTask extends FutureTask<String>
{
    CallbackInterface callback;

    public AlertingFutureTask(Runnable runnable, Callback callback)
    {
        super(runnable, null);
        this.callback = callback;
    }

    @Override
    protected void done()
    {
        callback.taskDone("alert alert");
    }
}
