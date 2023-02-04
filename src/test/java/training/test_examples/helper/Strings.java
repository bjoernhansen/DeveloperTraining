package training.test_examples.helper;

public final class Strings
{
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
    
    private Strings()
    {
        throw new UnsupportedOperationException();
    }
}
