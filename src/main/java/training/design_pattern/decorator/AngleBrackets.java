package training.design_pattern.decorator;

public class AngleBrackets implements Parenthesizer
{
    private final Parenthesizer
        parenthesizer;

    public AngleBrackets(Parenthesizer parenthesizer)
    {
        this.parenthesizer = parenthesizer;
    }

    @Override
    public String parenthesize(String text)
    {
        return "<" + this.parenthesizer.parenthesize(text) + ">";
    }
}
