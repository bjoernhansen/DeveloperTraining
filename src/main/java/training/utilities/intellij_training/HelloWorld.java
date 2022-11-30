package training.utilities.intellij_training;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

public class HelloWorld
{
    static String[] myRandomStrings = {"sdiashfdfhfm FDFDSIFIFHFADSOFADSH", "dfsdf", "dfdf"};
    
    
    public static void main(String[] args)
    {
        
        
        Map<String, Integer> myMapStringIntegerMap = Stream.of(myRandomStrings)
                                                           .collect(Collectors.toUnmodifiableMap(identity(), String::length));
        
        
        myMapStringIntegerMap.entrySet()
                             .forEach(System.out::println);
        
        
    }
    
}
