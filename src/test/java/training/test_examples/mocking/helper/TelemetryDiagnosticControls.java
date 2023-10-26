package training.test_examples.mocking.helper;

public class TelemetryDiagnosticControls
{
    public static final String
            SOME_MESSAGE = "some message";

    private final TelemetryClient
        telemetryClient;
    
    
    public TelemetryDiagnosticControls(TelemetryClient telemetryClient)
    {
        this.telemetryClient = telemetryClient;
    }
    
    public void checkTransmission()
    {
        if(!telemetryClient.isOnline())
        {
            throw new IllegalStateException("Unable to connect.");
        }
        telemetryClient.send(SOME_MESSAGE, "we don't care about this String");
        telemetryClient.configure("TestCaptor");
        telemetryClient.receive();
    }
    
    public double receive()
    {
        return telemetryClient.receive();
    }
}
