package training.test_examples.parameterized_tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import training.test_examples.helper.SimpleMath;
import training.test_examples.helper.Strings;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueAndNullSourceTest
{
    @ParameterizedTest(name = "Test Nr. {index}: square of {0} is odd")
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(SimpleMath.isOdd(number));
    }
    
    @ParameterizedTest
    @NullSource // auch null wird nun übergeben
    @ValueSource(strings = {"", "  ", "\n", "\t"})
    void returnsTrueForStringsLongerThan3(String string) {
        assertTrue(Strings.isBlank(string));
    }
    
    @ParameterizedTest
    @EmptySource
    void emptyListIsEmpty(List<String> strings) {
        assertTrue(strings.isEmpty());
    }
}
