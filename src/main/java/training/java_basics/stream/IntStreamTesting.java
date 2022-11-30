package training.java_basics.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class IntStreamTesting
{
    public static void main(String[] args)
    {
        // Maximum ausgeben
        System.out.println(IntStream.range(-12, 24)
                                    .map(x -> -x * x + 2)
                                    .max()
                                    .getAsInt());
        
        // Mapping mit eigener Funktion
        IntStream.range(32, 100)
                 .map(IntStreamTesting::square)
                 .forEach(System.out::println);
    
        // Zahlen aufsummieren
        // https://www.baeldung.com/java-stream-sum
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
    
        // IntStream.sum() verwenden
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
        Stream.of(1, 2, 3, 4, 5, 6)
              .mapToInt(Integer::intValue)
              .sum();
    
        IntStream.range(1, 200)
                 .map(i -> i * i)
                 .filter(i -> i % 35 == 0)
                 .sorted()
                 .average()
                 .ifPresent(System.out::println);
        
        IntStream.range(0, 50)
                 .boxed()
                 .collect(Collectors.toList())
                 .forEach(System.out::println);
    
        // Sortieren in umgekehrter Reihenfolge
        List<Integer> intList2 = List.of(2, 4, 7, 10, 1);
        System.out.println(intList.stream()
                                  .sorted(Collections.reverseOrder())
                                  .map(IntStreamTesting::square)
                                  .findFirst()
                                  .orElse(0));
    
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    
        List<Integer> result = new ArrayList<>();
        
        for (Integer integer : list)
        {
            if (integer%2==1)
            {
                result.add(integer);
            }
        }
    }
    
    private static int square(int number)
    {
        return number * number;
    }
}