package training.design_pattern.memento;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OriginatorTest
{
    public static final String
        FIRST_STRING = "A";
        
    public static final String
        NEXT_STRING = "next String";
    
    public static final int
        FIRST_INTEGER = 1;
    
    
    @Test
    void isOriginatorRestoringLastContentCorrectly()
    {
        Originator originator = new Originator(FIRST_STRING, FIRST_INTEGER);
        
        originator.setInteger(14);
        originator.setString(NEXT_STRING);
        
        assertThat(originator.getString()).isEqualTo(NEXT_STRING);
        
        originator.redo();
        originator.redo();
        
        assertThat(originator.getString()).isEqualTo(FIRST_STRING);
        assertThat(originator.getInteger()).isEqualTo(FIRST_INTEGER);
    }
}