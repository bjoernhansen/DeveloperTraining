package training.java_basics.collections;

import training.java_basics.hero.RandomNameCreator;

import java.util.*;

class CollectionTest
{
    private static final int NUMBER_OF_ELEMENTS = 25;

    private static final LinkedList <String> nameList = new LinkedList<>();


    public static void main(String[] args)
    {
        for(int i = 0; i < NUMBER_OF_ELEMENTS; i++)
        {
            nameList.add(RandomNameCreator.createName());
        }

        System.out.println(nameList);
        nameList.forEach(System.out::println);
    }
}