package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.NoiseMaker;
import training.test_examples.mocking.helper.NoiseRepeater;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MultipleExecutionsVerifyTest
{
    @Mock
    private NoiseMaker noiseMaker;
    
    @InjectMocks
    private NoiseRepeater noiseRepeater;
    
    
    private static final int
        NUMBER_OF_REPEATS = 3;
    
    private static final String
        DESIRED_TEXT = "My text!";
    
    
    @Test
    void mockTest()
    {
        when(noiseMaker.makeNoise()).thenReturn(DESIRED_TEXT);
        noiseRepeater.setNumberOfRepeats(NUMBER_OF_REPEATS);
        String noise = noiseRepeater.generateNoise();
        
        verify(noiseMaker, times(NUMBER_OF_REPEATS)).makeNoise();
        assertThat(noise).isEqualTo(DESIRED_TEXT+DESIRED_TEXT+DESIRED_TEXT);
    }
}
