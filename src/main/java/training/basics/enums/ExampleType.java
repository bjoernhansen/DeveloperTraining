package training.basics.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum ExampleType
{
    EXAMPLE_ONE(1),
    EXAMPLE_TWO(2),
    EXAMPLE_THREE(3);
    
    
    private static final List<ExampleType>
        VALUES = List.of(values());
    
    private static final Map<String, ExampleType>
        exampleTypes = new HashMap<>();
    
    static
    {
        Arrays.stream(values())
              .forEach(exampleType -> exampleTypes.put(exampleType.name, exampleType));
    }
    
    private final int
        number;
    
    private final String
        name;
    
    
    ExampleType(int number)
    {
        this.number = number;
        this.name = Integer.toString(number);
    }
    
    public static List<ExampleType> getValues()
    {
        return VALUES;
    }
    
    public static ExampleType getExampleType(String notation)
    {
        return exampleTypes.get(notation);
    }
    
    public static int getValueCount()
    {
        return VALUES.size();
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public String getName()
    {
        return name;
    }
}