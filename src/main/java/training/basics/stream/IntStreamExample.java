package training.basics.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.joining;


public class IntStreamExample
{
    public static void main(String[] args)
    {
        // Maximum ausgeben
        int max = IntStream.range(-12, 24)
                           .map(x -> -x * x + 2)
                           .max()
                           .orElse(Integer.MIN_VALUE);
        System.out.println(max);
        
        // Mapping mit eigener Funktion
        IntStream.range(32, 100)
                 .map(IntStreamExample::square)
                 .forEach(System.out::println);
        
        // Summen mit Stream bilden
        // https://www.baeldung.com/java-stream-sum
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        
        int sum1 = intList.stream()
                          .mapToInt(Integer::intValue)
                          .sum();
        
        // reduce und Lambda-Ausdruck verwenden
        int sum2 = intList.stream()
                          .reduce(0, (a, b) -> a + b + 1);
        
        // reduce und Methoden-Referenz verwenden
        int sum3 = intList.stream()
                          .reduce(0, Integer::sum); // oder eigene Methode als Referenz übergeben
        
        // Direkt einen IntStream aus Zahlen erzeugen
        int sum4 = Stream.of(1, 2, 3, 4, 5, 6)
                         .mapToInt(Integer::intValue)
                         .sum();
        
        String sums = Stream.of(sum1, sum2, sum3, sum4)
                            .map(String::valueOf)
                            .collect(joining(", "));
        System.out.println("Summen: " + sums);
        
        IntStream.range(1, 200)
                 .map(i -> i * i)
                 .filter(i -> i % 35 == 0)
                 .sorted()
                 .average()
                 .ifPresent(System.out::println);
        
        IntStream.range(0, 50)
                 .boxed()
                 .toList()
                 .forEach(System.out::println);
        
        // Sortieren in umgekehrter Reihenfolge
        List<Integer> intListUnordered = List.of(2, 4, 7, 10, 1);
        System.out.println(intListUnordered.stream()
                                           .sorted(reverseOrder())
                                           .map(IntStreamExample::square)
                                           .findFirst()
                                           .orElse(0));
    }
    
    private static int square(int number)
    {
        return number * number;
    }
}