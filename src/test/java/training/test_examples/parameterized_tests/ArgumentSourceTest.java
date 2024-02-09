package training.test_examples.parameterized_tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import training.test_examples.helper.Strings;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("ArgumentSourceTest")
class ArgumentSourceTest
{
    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(BlankStringsArgumentsProvider.class)
    @DisplayName("isBlank liefert true bei Übergabe von")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String testDescription, String input)
    {
        assertTrue(Strings.isBlank(input));
    }
    
    static class BlankStringsArgumentsProvider implements ArgumentsProvider
    {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context)
        {
            return Stream.of(
                Arguments.of("null", null),
                Arguments.of("Leerstring", ""),
                Arguments.of("String aus Leerzeichen", "   "));
        }
    }
    
    @ParameterizedTest()
    @ArgumentsSource(BlankStringsArgumentsProvider2.class)
    @DisplayName("isBlank liefert immer noch true bei Übergabe von")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider2(String input)
    {
        assertTrue(Strings.isBlank(input));
    }
    
    static class BlankStringsArgumentsProvider2 implements ArgumentsProvider
    {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context)
        {
            return Stream.of(
                arguments(named("null", null)),
                arguments(named("Leerstring", "")),
                arguments(named("String aus Leerzeichen", "   ")));
        }
    }
}
