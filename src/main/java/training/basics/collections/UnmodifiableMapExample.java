package training.basics.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnmodifiableMapExample
{

    public static final String HELLO = "Hello";
    public static final String JOHN = "John";

    public static void main(String[] args)
    {
        Map<String, Integer> map1 = Collections.unmodifiableMap(Stream.of(new Object[][]{
                {HELLO, 1 },
                {JOHN, 2 },
        }).collect(Collectors.toMap(data -> (String)data[0], data -> (Integer)data[1])));

        Map <String, Integer> map2 = Map.of(HELLO, 1, JOHN, 2);

        Map<String, Integer> map3 = Map.ofEntries(
                Map.entry(HELLO, 1),
                Map.entry(JOHN, 2)
        );

        Map<String, Integer> map4 = Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>("HELLO", 1),
                new AbstractMap.SimpleEntry<>("JOHN", 2)
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        List.of(map1, map2, map3, map4).forEach(UnmodifiableMapExample::printMapElements);
    }

    private static void printMapElements(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.printf("key: %s; value: %s%n", key, value));
    }
}