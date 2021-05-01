package com.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class IntStreamTesting {

    public static void main(String[] args) {
        IntStream.range(32, 100)
                 .map(IntStreamTesting::square)
                 .forEach(System.out::println);

        IntStream.range(32, 100)
                 .forEach(System.out::println);

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
    }

    public static int square(int number) {
        return number * number;
    }
}