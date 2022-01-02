package com.basics.functionalInterface;

import java.util.Comparator;

public class HeroHeightComperator implements Comparator<Hero>
{
    @Override
    public int compare(Hero hero1, Hero hero2)
    { 
        if (hero1.getHeight() > hero2.getHeight()) 
        {
            return 1;
        } 
        else if(hero1.getHeight() < hero2.getHeight())
        {
            return -1;
        } 
        return 0;
    }
}