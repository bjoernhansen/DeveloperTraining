package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.TelemetryClient;
import training.test_examples.mocking.helper.TelemetryDiagnosticControls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DynamicBehaviourTest
{
    @Mock
    private TelemetryClient
        client;
    
    @InjectMocks
    private TelemetryDiagnosticControls
        controls;
    
    
    
    @Test
    public void dynamicBehaviourTest()
    {
        // für "dynamisches" Verhalten
        double RECEIVE_VALUE = 0.2;
        when(client.receive()).then(invocation -> RECEIVE_VALUE/*Math.random()*/);
        
        assertThat(controls.receive()).isEqualTo(RECEIVE_VALUE);
    }
    
    
    @Test
    public void thenAnswerTest()
    {
        when(client.isOnline()).thenAnswer(invocation -> DynamicBehaviourTest.getFalse());
        assertThrows(IllegalStateException.class, () -> controls.checkTransmission());
    }
    
    private static boolean getFalse()
    {
        return false;
    }
}
