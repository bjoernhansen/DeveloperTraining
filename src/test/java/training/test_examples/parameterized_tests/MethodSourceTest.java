package training.test_examples.parameterized_tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import training.test_examples.helper.Strings;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MethodSourceTest
{
    @ParameterizedTest
    @MethodSource("providerMethod")
    void testWithParametersFromMethods(String parameter)
    {
        assertTrue(parameter.length() >= 3);
    }
    
    static Iterable<String> providerMethod() {
        return Arrays.asList("one", "two", "three");
    }
    
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }
    
    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
            Arguments.of(null, true),
            Arguments.of("", true),
            Arguments.of("  ", true),
            Arguments.of("not blank", false)
        );
    }
}
