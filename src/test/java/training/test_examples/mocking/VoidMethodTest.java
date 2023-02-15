package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

public class VoidMethodTest
{

    @Mock
    TelemetryClient telemetryClient;

 
    @InjectMocks
    TelemetryDiagnosticControls telemetryDiagnosticControls;
    
    

    @Test
    public void exampleOne()
    {
        doAnswer((i) -> {
            System.out.println("TelemetryClient configured with  = " + i.getArgument(0));
            assertEquals("TestCaptor", i.getArgument(0));
            return null;
        }).when(telemetryClient).configure(anyString());
        
        telemetryDiagnosticControls.checkTransmission();
    
        doThrow(IllegalArgumentException.class).when(telemetryClient).configure(null);
    }


    
    
}
