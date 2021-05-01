package com.collections;

import java.util.*;
import java.util.stream.IntStream;

class CollectionTest
{
    static final int NUMBER_OF_ELEMENTS = 100;
    private static Random random = new Random();

    public static LinkedList <String> nameList = new LinkedList<>();


    public static void main(String[] args)
    {
        for(int i = 0; i < NUMBER_OF_ELEMENTS; i++)
        {
            nameList.add(RandomNameCreator.getName());
        }

        String[] nameArray = nameList.toArray(new String[0]);

        System.out.println(nameList);
        nameList.forEach(System.out::println);
    }
}