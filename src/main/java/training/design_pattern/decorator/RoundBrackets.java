package training.design_pattern.decorator;

public class RoundBrackets implements Parenthesizer
{
    private final Parenthesizer
        parenthesizer;

    public RoundBrackets(Parenthesizer parenthesizer)
    {
        this.parenthesizer = parenthesizer;
    }

    @Override
    public String parenthesize(String text)
    {
        return "(" + this.parenthesizer.parenthesize(text) + ")";
    }
}
