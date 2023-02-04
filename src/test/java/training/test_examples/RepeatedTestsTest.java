package training.test_examples;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RepeatedTestsTest
{
    @RepeatedTest(3)
    void repeatedTest(TestInfo testInfo) {
        System.out.println("Executing repeated test");
        
        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }
    
    @RepeatedTest(value = 3, name = "Custom name {currentRepetition}/{totalRepetitions}")
    void repeatedTestWithCustomDisplayName(TestInfo testInfo) {
        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }
    
    @RepeatedTest(3)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());
        
        assertEquals(3, repetitionInfo.getTotalRepetitions());
    }
}
