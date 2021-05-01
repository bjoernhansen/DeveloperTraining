package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


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


    }


    private static Object getObject() {
        return Arrays.asList("123", "Klaus", "Gogo");
    }

}
