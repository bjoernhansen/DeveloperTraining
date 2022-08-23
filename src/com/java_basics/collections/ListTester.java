package com.java_basics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class ListTester {


    public static void main(String[] args) {


        List<String> intList = Arrays.asList("a",
                                             "b",
                                             "c",
                                             "d",
                                             "e",
                                             "fg",
                                             "h",
                                             "ijk",
                                             "l",
                                             "m",
                                             "ab",
                                             "cd",
                                             "ef",
                                             "g");

        AtomicInteger counter = new AtomicInteger();
        Map<Integer, List<String>> groups = intList.stream()
                                                   .collect(Collectors.groupingBy(pr -> counter.getAndIncrement() / 5));


        List<List<String>> subSets = new ArrayList<>(groups.values());

        subSets.forEach(System.out::println);
        
        
        List<String> list = List.of("1", "2", "3");
    
        // loest UnsupportedOperationException aus
        list.set(1, "4");
        list.forEach(System.out::println);
    }


    private static Object getObject() {
        return Arrays.asList("123", "Klaus", "Gogo");
    }

}
