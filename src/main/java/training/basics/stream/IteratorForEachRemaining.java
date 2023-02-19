package training.basics.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class IteratorForEachRemaining {

    public static void main(String[] args) {
        Iterator<String> sourceIterator = Arrays.asList("A", "B", "C").iterator();

        Collection<String> copyList = new ArrayList<>();
        sourceIterator.forEachRemaining(copyList::add);
    
        List<Integer> myList = Arrays.asList(null, null, null, 1);
    
        System.out.println(myList.stream()
                                 .filter(Objects::nonNull)
                                 .map(i -> i * i)
                                 .filter(i -> i > 0)
                                 .findFirst()
                                 .orElse(0));
    
    
    }
}
