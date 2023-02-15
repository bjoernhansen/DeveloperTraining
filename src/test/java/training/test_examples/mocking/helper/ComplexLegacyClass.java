package training.test_examples.mocking.helper;

import java.util.List;

public class ComplexLegacyClass
{
    public static List<String> EXAMPLE_LIST = List.of("one", "two", "three");
    
    
    public List<String> complexListReturn(int i)
    {
        return EXAMPLE_LIST;
    }
}
