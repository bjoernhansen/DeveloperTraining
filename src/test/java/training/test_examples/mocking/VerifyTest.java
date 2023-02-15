package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static training.test_examples.mocking.helper.TelemetryDiagnosticControls.SOME_MESSAGE;

public class VerifyTest
{
    @Mock
    private TelemetryClient
        client;
    
    @InjectMocks
    private TelemetryDiagnosticControls
        controls;
    

    @Test
    public void multipleParameterTest()
    {
        when(client.isOnline()).thenReturn(true);
        controls.checkTransmission();
        verify(client).send(eq(SOME_MESSAGE), any());
    }
}
