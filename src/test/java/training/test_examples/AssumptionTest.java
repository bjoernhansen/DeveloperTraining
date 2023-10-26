package training.test_examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTest
{
    @Test
    void exitIfFalseIsTrue() {
        // Test wird abgebrochen, wenn die Bedingung nicht erfüllt wird, aber kein automatischer Test-Failure
        assumeTrue(false);
        System.exit(1);
    }
    
    @Test
    void exitIfTrueIsFalse() {
        assumeFalse(this::truism);
        System.exit(1);
    }
    
    private boolean truism() {
        return true;
    }
    
    @Test
    void exitIfNullEqualsString() {
        assumingThat(
            "null".equals(null),
            () -> System.exit(1)
        );
    }
}
