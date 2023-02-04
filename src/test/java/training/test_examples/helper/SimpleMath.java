package training.test_examples.helper;

public final class SimpleMath
{
    public static int square(int i)
    {
        return i*i;
    }
    
    public static boolean isOdd(int i)
    {
        return i%2 != 0;
    }
    
    private SimpleMath()
    {
        throw new UnsupportedOperationException();
    }
}
