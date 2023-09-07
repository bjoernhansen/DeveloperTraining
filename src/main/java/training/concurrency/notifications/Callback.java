package training.concurrency.notifications;

class Callback implements CallbackInterface
{
    @Override
    public void taskDone(String details)
    {
        System.out.println("task complete: " + details);
        // Alerts/notifications go here
    }
}
