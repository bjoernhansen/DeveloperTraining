package training.design_pattern.decorator;

public class NoBracket implements Parenthesizer
{
    @Override
    public String parenthesize(String text)
    {
        return text;
    }
}
