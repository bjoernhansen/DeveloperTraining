package training.test_examples.mocking;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import training.test_examples.mocking.helper.StaticClass;

import static org.assertj.core.api.Assertions.assertThat;

public class StaticMockTest
{
    private static final int
        NUMBER = 3;
    
    @Test
    void staticMockTest()
    {
        assertThat(StaticClass.square(NUMBER)).isEqualTo(NUMBER * NUMBER);
        
        try(MockedStatic<StaticClass> staticMock = Mockito.mockStatic(StaticClass.class))
        {
            staticMock.when(() -> StaticClass.square(3)).thenReturn(1);
            assertThat(StaticClass.square(NUMBER)).isEqualTo(1);
        }
    
        assertThat(StaticClass.square(NUMBER)).isEqualTo(NUMBER * NUMBER);
    }
    
    
}
