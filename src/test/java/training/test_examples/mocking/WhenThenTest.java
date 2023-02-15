package training.test_examples.mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class WhenThenTest
{
    @Mock
    private TelemetryClient
        client;
    
    @InjectMocks
    private TelemetryDiagnosticControls
        controls;
    
    
    @BeforeEach
    void before()
    {
        // Default
        when(client.isOnline()).thenReturn(true);
    }
    
    @Test
    public void consecutiveReturnValuesTest()
    {
        when(client.isOnline()).thenReturn(true, false); // hier überschreiben wir den Default
        controls.checkTransmission();
        assertThrows(IllegalStateException.class, () -> controls.checkTransmission());
    }
    
    @Test
    public void checkMockReset()
    {
        when(client.isOnline()).thenReturn(true); // hier überschreiben wir den Default
        reset(client); // <-- Mock wird vollständig resettet
        assertThrows(IllegalStateException.class, () -> controls.checkTransmission());
    }
}
