package training.design_pattern.decorator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ParenthesizerTest
{
    @Test
    void shouldDecorateCorrectly()
    {
        String text = "abc";
        Parenthesizer parenthesizer = new NoBracket();

        AngleBrackets angleBrackets = new AngleBrackets(new NoBracket());
        var parenthesizedText = new RoundBrackets(angleBrackets).parenthesize(text);

        assertThat(parenthesizedText).isEqualTo("(<abc>)");
    }
}
