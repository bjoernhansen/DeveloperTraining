package com.basics.functionalInterface;

import java.util.Random;
import java.util.function.UnaryOperator;

public class RandomNameCreator
{
    private static final String [] 
        CONSONANT = {   "b", "ch", "d", "f", "g", "h", "j", 
                        "k", "l", "m", "n", "p", "pf", "qu", 
                        "r", "s", "st", "sch", "u", "v", "w",
                        "x", "y", "z", ""},  
        VOWEL     = {   "a", "e", "i", "o", "u", "ö", "ü", 
                        "ä", "y", "au", "eu", "ei"},
        GENDER_SUFFIX = {"us", "a"};       
    
    
    private RandomNameCreator()
    {
        
    }    
        
    public static String getName(UnaryOperator<String> stringFormatter)
    {
        Random r = new Random();        
        StringBuilder name = new StringBuilder();
        for(int i = 0; i < r.nextInt(2)+1; i++)
        {
            name.append(CONSONANT[r.nextInt(CONSONANT.length)]);
            name.append(VOWEL[r.nextInt(VOWEL.length)]);
        }
        name.append(CONSONANT[r.nextInt(CONSONANT.length)] + GENDER_SUFFIX[r.nextInt(2)]);
        return stringFormatter.apply(name.toString());
    }
}
