package training.test_examples.mocking.helper;

public class StaticClass
{
    public static int square(int i)
    {
        return i*i;
    }
    
    private StaticClass()
    {
        throw new UnsupportedOperationException("Utility class Calculations can not be instantiated.");
    }
}
