package training.test_examples.parameterized_tests.variable_source;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import training.test_examples.helper.Strings;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VariableSourceTest
{
    static Stream<Arguments> arguments = Stream.of(
        Arguments.of(null, true), // null strings should be considered blank
        Arguments.of("", true),
        Arguments.of("  ", true),
        Arguments.of("not blank", false)
    );
    
    @ParameterizedTest
    @VariableSource("arguments")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsVariableSource(
        String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }
}
