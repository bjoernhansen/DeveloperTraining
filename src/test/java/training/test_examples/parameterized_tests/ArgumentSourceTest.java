package training.test_examples.parameterized_tests;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import training.test_examples.helper.Strings;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ArgumentSourceTest
{
    @ParameterizedTest
    @ArgumentsSource(BlankStringsArgumentsProvider.class)
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String input)
    {
        assertTrue(Strings.isBlank(input));
    }
    
    static class BlankStringsArgumentsProvider implements ArgumentsProvider
    {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context)
        {
            return Stream.of(
                Arguments.of((String) null),
                Arguments.of(""),
                Arguments.of("   ")
            );
        }
    }
}
