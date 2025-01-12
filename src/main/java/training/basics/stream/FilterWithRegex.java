package training.basics.stream;

import java.util.List;
import java.util.regex.Pattern;


public class FilterWithRegex
{
    public static void main(String[] args)
    {
        List<String> fruits = List.of("apple", "banana", "cherry", "apricot", "avocado");
        filterWordsStartingWithA(fruits).forEach(System.out::println);
    }
    
    private static List<String> filterWordsStartingWithA(List<String> words)
    {
        Pattern pattern = Pattern.compile("^a.*");
        return words.stream()
                    .filter(pattern.asPredicate())
                    .toList();
    }
}
