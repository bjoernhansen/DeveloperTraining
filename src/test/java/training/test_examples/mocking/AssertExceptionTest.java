package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AssertExceptionTest
{
    @Mock
    private TelemetryClient
        client;
    
    @InjectMocks
    private TelemetryDiagnosticControls
        controls;
    
    
    @Test
    public void throwsWhenNotOnline()
    {
        // false ist zwar default, aber wir machen es hier explizit, was wir erwarten
        when(client.isOnline()).thenReturn(false);
        
        assertThrows(IllegalStateException.class, () -> controls.checkTransmission());
    }
    
    @Test
    public void throwWhenReceiveStubTest()
    {
        when(client.receive()).thenThrow(new RuntimeException());
    
        assertThrows(RuntimeException.class, () -> controls.receive());
    }
}
