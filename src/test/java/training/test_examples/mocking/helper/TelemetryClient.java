package training.test_examples.mocking.helper;

public class TelemetryClient
{
    private final boolean
        isOnline;
    
    
    public TelemetryClient(boolean isOnline)
    {
        this.isOnline = isOnline;
    }
    
    public boolean isOnline()
    {
        return isOnline;
    }
    
    public void send(String someMessage, String someIrrelevantString)
    {
        // do something
    }
    
    public void configure(String configureKey)
    {
        // do something
    }
    
    public double receive()
    {
        return 0.001;
    }
}
