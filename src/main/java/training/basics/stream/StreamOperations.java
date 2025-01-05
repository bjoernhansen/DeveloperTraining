package training.basics.stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamOperations {
    private static final List<String>
        NAMES = List.of("Charlie", "Alice", "Bob");
    private static final Random
        RANDOM = new Random();
    
    public static void main(String[] args) {
        StreamOperations operations = new StreamOperations();
        
        operations.filterExample();
        operations.mapExample();
        operations.flatMapExample();
        operations.mapMultiExample();
        operations.distinctExample();
        operations.sortedExample();
        operations.peekExample();
        operations.limitExample();
        operations.skipExample();
        operations.takeWhileExample();
        operations.dropWhileExample();
        operations.forEachExample();
        operations.allMatchExample();
        operations.anyMatchExample();
        operations.noneMatchExample();
        operations.findFirstExample();
        operations.findAnyExample();
        operations.reduceExample();
        operations.collectExample();
        operations.generateExample();
        operations.iterateExample();
        operations.parallelExample();
    }
    
    // 1. filter
    public void filterExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .toList();
        System.out.println("Filter Example: " + evens);
    }
    
    // 2. map
    public void mapExample() {
        List<Integer> nameLengths = NAMES.stream()
                                         .map(String::length)
                                         .toList();
        System.out.println("Map Example: " + nameLengths);
    }
    
    // 3. flatMap
    public void flatMapExample() {
        List<List<String>> nestedLists = List.of(
            List.of("a", "b"),
            List.of("c", "d"),
            List.of("e", "f")
        );
        List<String> flattened = nestedLists.stream()
                                            .flatMap(List::stream)
                                            .toList();
        System.out.println("FlatMap Example: " + flattened);
    }
    
    // 4. mapMulti
    public void mapMultiExample() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> expanded = numbers.stream()
                                        .<Integer>mapMulti((num, consumer) -> {
                                            consumer.accept(num);
                                            consumer.accept(num * 10);
                                        })
                                        .toList();
        System.out.println("MapMulti Example: " + expanded);
    }
    
    // 5. distinct
    public void distinctExample() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4);
        List<Integer> unique = numbers.stream()
                                      .distinct()
                                      .toList();
        System.out.println("Distinct Example: " + unique);
    }
    
    // 6. sorted
    public void sortedExample() {
        List<String> sortedNames = NAMES.stream()
                                        .sorted()
                                        .toList();
        System.out.println("Sorted Example: " + sortedNames);
    }
    
    // 7. peek
    public void peekExample() {
        System.out.println("Peek Example:");
        NAMES.stream()
             .peek(System.out::println)
             .forEach(name -> {});
    }
    
    // 8. limit
    public void limitExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> firstTwo = numbers.stream()
                                        .limit(2)
                                        .toList();
        System.out.println("Limit Example: " + firstTwo);
    }
    
    // 9. skip
    public void skipExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> skipped = numbers.stream()
                                       .skip(3)
                                       .toList();
        System.out.println("Skip Example: " + skipped);
    }
    
    // 10. takeWhile
    public void takeWhileExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 3, 2);
        List<Integer> taken = numbers.stream()
                                     .takeWhile(n -> n < 4)
                                     .toList();
        System.out.println("TakeWhile Example: " + taken);
        // Ausgabe: TakeWhile Example: [1, 2, 3]
    }
    
    // 11. dropWhile
    public void dropWhileExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 3, 2);
        List<Integer> dropped = numbers.stream()
                                       .dropWhile(n -> n < 4)
                                       .toList();
        System.out.println("DropWhile Example: " + dropped);
        // Ausgabe: DropWhile Example: [4, 5, 3, 2]
    }
    
    // 12. forEach
    public void forEachExample() {
        System.out.println("ForEach Example:");
        NAMES
             .forEach(System.out::println);
    }
    
    // 13. allMatch
    public void allMatchExample() {
        List<Integer> numbers = List.of(2, 4, 6, 8);
        boolean allEven = numbers.stream()
                                 .allMatch(n -> n % 2 == 0);
        System.out.println("AllMatch Example: " + allEven); // true
    }
    
    // 14. anyMatch
    public void anyMatchExample() {
        List<Integer> numbers = List.of(1, 3, 5, 8);
        boolean hasEven = numbers.stream()
                                 .anyMatch(n -> n % 2 == 0);
        System.out.println("AnyMatch Example: " + hasEven); // true
    }
    
    // 15. noneMatch
    public void noneMatchExample() {
        List<Integer> numbers = List.of(1, 3, 5, 7);
        boolean noEven = numbers.stream()
                                .noneMatch(n -> n % 2 == 0);
        System.out.println("NoneMatch Example: " + noEven); // true
    }
    
    // 16. findFirst
    public void findFirstExample() {
        String firstName = NAMES.stream()
                                .findFirst()
                                .orElse("No Name");
        System.out.println("FindFirst Example: " + firstName);
    }
    
    // 17. findAny
    public void findAnyExample() {
        String anyName = NAMES.stream()
                              .findAny()
                              .orElse("No Name");
        System.out.println("FindAny Example: " + anyName);
    }
    
    // 18. reduce
    public void reduceExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Reduce Example: " + sum); // 15
    }
    
    // 19. collect
    public void collectExample() {
        String concatenated = String.join(", ", NAMES);
        System.out.println("Collect Example: " + concatenated); // Alice, Bob, Charlie
    }
    
    // 20. generate
    public void generateExample() {
        List<Integer> randomNumbers = Stream.generate(() -> RANDOM.nextInt() * 100)
                                            .limit(5)
                                            .toList();
        System.out.println("Generate Example: " + randomNumbers);
    }
    
    // 21. iterate
    public void iterateExample() {
        List<Integer> numbers = Stream.iterate(1, n -> n + 1)
                                      .limit(5)
                                      .toList();
        System.out.println("Iterate Example: " + numbers); // [1, 2, 3, 4, 5]
    }
    
    // 22. parallel
    public void parallelExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.parallelStream()
                                       .map(n -> n * n)
                                       .toList();
        System.out.println("Parallel Example: " + squares);
    }
}