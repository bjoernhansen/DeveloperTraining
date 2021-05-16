package com.collections;

import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class RandomNameCreator
{
    private static final List<String>
            CONSONANT = List.of("b", "ch", "d", "f", "g", "h", "j",
            "k", "l", "m", "n", "p", "pf", "qu",
            "r", "s", "sp", "st", "sch", "u", "v", "w",
            "x", "y", "z", ""),
            VOWEL     = List.of("a", "e", "i", "o", "u", "ö", "ü",
                    "ä", "y", "au", "eu", "ei"),
            GENDER_SUFFIX = List.of("us", "a");

    private RandomNameCreator(){}


    public static String getName()
    {
        UnaryOperator<String> stringFormatter = (
                s) -> Character.toUpperCase(s.charAt(0))
                + s.substring(1);
        return getName(stringFormatter);
    }

    private static String getName(UnaryOperator<String> stringFormatter)
    {
        Random random = new Random();
        StringBuilder name = new StringBuilder();
        for(int i = 0; i < random.nextInt(2) + 1; i++)
        {
            name.append(CONSONANT.get(random.nextInt(CONSONANT.size())));
            name.append(VOWEL.get(random.nextInt(VOWEL.size())));
        }
        name.append(CONSONANT.get(random.nextInt(CONSONANT.size())))
            .append(GENDER_SUFFIX.get(random.nextInt(2)));
        return stringFormatter.apply(name.toString());
    }
}