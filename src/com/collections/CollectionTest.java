package com.collections;

import java.util.*;
import java.util.stream.IntStream;

class CollectionTest
{
    private static final int NUMBER_OF_ELEMENTS = 25;

    public static LinkedList <String> nameList = new LinkedList<>();


    public static void main(String[] args)
    {
        for(int i = 0; i < NUMBER_OF_ELEMENTS; i++)
        {
            nameList.add(RandomNameCreator.getName());
        }

        System.out.println(nameList);
        nameList.forEach(System.out::println);
    }
}