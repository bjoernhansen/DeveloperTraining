package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;


public class IteratorForEachRemaining {

    public static void main(String[] args) {
        Iterator<String> sourceIterator = Arrays.asList("A", "B", "C").iterator();

        Collection<String> copyList = new ArrayList<>();
        sourceIterator.forEachRemaining(copyList::add);
        Stream<String> targetStream = copyList.stream();
    }
}
