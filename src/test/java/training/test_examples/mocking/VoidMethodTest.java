package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VoidMethodTest
{
    @Mock
    TelemetryClient telemetryClient;
 
    @InjectMocks
    TelemetryDiagnosticControls telemetryDiagnosticControls;
    

    @Test
    void exampleOne()
    // TODO Warum schlägt dieser Test fehl?
    {
        when(telemetryClient.isOnline()).thenReturn(true); // hier überschreiben wir den Default

        doAnswer((i) -> {
            System.out.println("TelemetryClient configured with  = " + i.getArgument(0));
            assertEquals("TestCaptor", i.getArgument(0));
            return null;
        }).when(telemetryClient).configure(anyString());

        telemetryDiagnosticControls.checkTransmission();
    }
}
