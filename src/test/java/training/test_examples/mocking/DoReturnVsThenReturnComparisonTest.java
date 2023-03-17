package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DoReturnVsThenReturnComparisonTest
{
    @Mock
    private TelemetryClient
        client;
    
    @InjectMocks
    private TelemetryDiagnosticControls
        controls;
    
    
    @Test
    public void doVsWhenReturnTest()
    {
        when(client.receive()).thenReturn(0.1);
        when(client.isOnline()).thenReturn(true);
        
        // when(client.receive()).thenReturn(Boolean.TRUE); // <-- Fehler zur Kompilierzeit
        
        // doReturn(Boolean.TRUE).when(client).receive(); // <-- würde kompilieren, aber es gibt einen Laufzeitfehler
        // beim Ausführen des Tests
        
        controls.checkTransmission();
        
        verify(client).receive();
    }
}
