package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CaptorTest
{
    @Mock
    private TelemetryClient
        client;
    
    @InjectMocks
    private TelemetryDiagnosticControls
        controls;
    
    @Captor
    private ArgumentCaptor<String>
        captor;
    
     
    @Test
    public void captureTheArgument()
    {
        when(client.isOnline()).thenReturn(true);
        controls.checkTransmission();
    
        // nicht mehr nötig wegen @Captor
        // ArgumentCaptor<String> captor = forClass(String.class);
        verify(client).configure(captor.capture());
        String text = captor.getValue();
        
        assertThat(text).isEqualTo("TestCaptor");
    }
}
