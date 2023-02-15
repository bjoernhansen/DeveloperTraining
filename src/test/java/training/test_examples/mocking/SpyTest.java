package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import training.test_examples.mocking.helper.ComplexLegacyClass;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class SpyTest
{
    @Spy
    private ComplexLegacyClass target;
    
    
    @Test
    public void returnsEmptyListWhenGivenCertainValue()
    {
        doReturn(Collections.emptyList()).when(target).complexListReturn(13);
        
        assertThat(target.complexListReturn(13)).isEmpty();
        assertThat(target.complexListReturn(12)).isNotEmpty();
    }
    

    



}
