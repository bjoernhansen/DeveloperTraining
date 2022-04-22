package com.basics.hero;

import java.util.Comparator;

public class HeroHeightComparator implements Comparator<Hero>
{
    @Override
    public int compare(Hero hero1, Hero hero2)
    {
        return Integer.compare(hero1.getHeight(), hero2.getHeight());
    }
}