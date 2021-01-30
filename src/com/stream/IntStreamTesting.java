package com.stream;

import java.util.stream.IntStream;


public class IntStreamTesting {


    public static void main(String[] args) {
        IntStream.range(32, 100).map(IntStreamTesting::square).forEach(System.out::println);
    }



    public static int square(int number){
        return number * number;
    }

}
