package training.java_basics.stream;


import training.java_basics.hero.Gender;
import training.java_basics.hero.Hero;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorTesting
{
    
    public static void main(String[] args)
    {
        List<Integer> intValues = IntStream.range(0, 50)
                                           .boxed()
                                           .collect(Collectors.toList());
    
        List<Integer> immutableIntValues = IntStream.range(0, 50)
                                           .boxed()
                                           .collect(Collectors.toUnmodifiableList());
         
        List<Hero> heros = Hero.getHeroes(10);
    
        // Unmodifiable Map anlegen, welche Heros auf ihre Größe
        Map<Hero, Integer> map = heros.stream()
                                      .collect(Collectors.toUnmodifiableMap(Function.identity(), Hero::getHeight));
        
        // Accumulate names into a List
        List<String> list = heros.stream()
                                 .map(Hero::getName)
                                 .collect(Collectors.toList());
            
        // Accumulate names into a TreeSet
        Set<String> set = heros.stream()
                               .map(Hero::getName)
                               .collect(Collectors.toCollection(TreeSet::new));
    
        // Convert elements to strings and concatenate them, separated by commas
        String joined = heros.stream()
                             .map(Hero::toString)
                             .collect(Collectors.joining(", "));
    
        // Compute sum of height of heros
        int total = heros.stream()
                         .mapToInt(Hero::getHeight)
                         .sum();
    
        // Anzahl von großen Helden >170
        long heroCount = heros.stream()
                              .filter(hero -> hero.getHeight() > 170)
                              .count();
        
        // für Statistiken
        IntSummaryStatistics result = heros.stream()
                                           .collect(Collectors.summarizingInt(Hero::getHeight));
        
        // Namen des größten Helden
        
        int heightMaximum = heros.stream()
                                   .map(Hero::getHeight)
                                   .max(Comparator.naturalOrder())
                                   .orElse(0);
        
        
        // Group heros by gender
        Map<Gender, List<Hero>> byGender
            = heros.stream()
                   .collect(Collectors.groupingBy(Hero::getGender));
    
        // Compute avg of height by gender
        Map<Gender, Double> avgHeightByGender
            = heros.stream()
                   .collect(Collectors.groupingBy(Hero::getGender, Collectors.averagingInt(Hero::getHeight)));
    
        // Partition heros by height
        Map<Boolean, List<Hero>> passingFailing =
            heros.stream()
                 .collect(Collectors.partitioningBy(s -> s.getHeight() >= 180));
        
        // In Gruppen bestimmter Größe einteilen
        AtomicInteger counter = new AtomicInteger();
        final int maximumGroupSize = 3;
        Map<Integer, List<Hero>> groupsOfHeros
            = heros.stream()
                   .collect(Collectors.groupingBy(pr -> counter.getAndIncrement() / maximumGroupSize));
    }
}
