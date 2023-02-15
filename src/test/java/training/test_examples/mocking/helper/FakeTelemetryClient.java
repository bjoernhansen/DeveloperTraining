package training.test_examples.mocking.helper;

public class FakeTelemetryClient extends TelemetryClient
{
    public FakeTelemetryClient(boolean isOnline)
    {
        super(isOnline);
    }
    
    @Override
    public double receive()
    {
        return Math.random();
    }
}
