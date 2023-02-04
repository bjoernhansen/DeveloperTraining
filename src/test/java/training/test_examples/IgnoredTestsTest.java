package training.test_examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class IgnoredTestsTest
{
    @Test
    @Disabled("Y U No Pass?!")
    void failingTest() {
        fail();
    }
}
