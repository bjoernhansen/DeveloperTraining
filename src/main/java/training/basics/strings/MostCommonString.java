package training.basics.strings;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


class MostCommonString
{
    public static final String APFEL = "Apfel";
    public static final String BANANE = "Banane";
    public static final String KIRSCHE = "Kirsche";
    
    public static void main(String[] args)
    {
        List<String> fruits = List.of(APFEL, BANANE, APFEL, APFEL, KIRSCHE, BANANE);
        String mostCommonFruit = findMostCommonString(fruits).orElse(null);
        
        System.out.println("Most common fruit: " + mostCommonFruit);
    }
    
    private static Optional<String> findMostCommonString(List<String> stringList)
    {
        if(stringList == null || stringList.isEmpty())
        {
            return Optional.empty();
        }
        Map<String, Long> haeufigkeitenMap =
            stringList.stream()
                      .collect(groupingBy(String::toString, counting()));
        
        return haeufigkeitenMap
            .entrySet()
            .stream()
            .max(comparingByValue())
            .map(Map.Entry::getKey);
    }
}
