package com.collections;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnmodifiableMapTester
{
    public static void main(String[] args)
    {


        Map<String, Integer> map = Collections.unmodifiableMap(Stream.of(new Object[][]{
                { "Hello", 1 },
                { "John", 2 },
        }).collect(Collectors.toMap(data -> (String)data[0], data -> (Integer)data[1])));



        map.forEach((key, value) -> System.out.println(String.format("key: %s; value: %s", key, value)));







    }


}




