package training.basics.stream;

import java.util.Arrays;
import java.util.Iterator;


public class IteratorForEachRemaining
{
    public static void main(String[] args)
    {
        Iterator<String> sourceIterator = Arrays.asList("A", "B", "C", "D")
                                                .iterator();
        // zwei Elemente des Iterators werden mit next() abgerufen
        sourceIterator.next();
        sourceIterator.next();
        System.out.print("Remaining Elements: ");
        sourceIterator.forEachRemaining(System.out::print); // zwei Elemente bleiben übrig
    }
}
