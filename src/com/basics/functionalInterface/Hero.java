package com.basics.functionalInterface;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Predicate;

public class Hero implements Comparable<Hero>
{        
    private String name;
    private int height;
    private boolean isRanged;
    
    private Map<Talent, Integer> talents;
    
        
    private Hero(Builder builder)
    {
        this.name = builder.name;
        this.height = builder.height;
        this.isRanged = builder.isRanged;
        this.talents = builder.talents;
    }
    
    public String getName()
    {
        return this.name;
    }

    public Integer getHeight()
    {
        return this.height;
    }

    public boolean isRanged()
    {
        return this.isRanged;
    }
    
    public int getStrength()
    {
        return this.talents.get(Talent.STRENGTH);
    }  
    
    public int getAgility()
    {
        return this.talents.get(Talent.AGILITY);
    } 
    
    public int getIntelligence()
    {
        return this.talents.get(Talent.INTELLIGENCE);
    } 
    
    
    public void shout()
    {
        System.out.println(this.toString());
    }
    
    
    public boolean checkMe(Predicate<Hero> checkFunction)
    {        
        return checkFunction.test(this);
    }
    
    @Override
    public String toString()
    {
        return "[Name: " + this.name + "; Größe: " + this.height + "]";
    }
    
    
    static class Builder
    {
        String name;
        int height;
        boolean isRanged;
        //@SuppressWarnings("unchecked")
        Map<Talent, Integer> talents = new EnumMap(Talent.class);
    
        @SuppressWarnings("hiding")
        Builder name(String name)
        {
            this.name = name;
            return this;
        }
        
        @SuppressWarnings("hiding")
        Builder height(int height)
        {
            this.height = height;
            return this;
        }
        
        @SuppressWarnings("hiding")
        Builder isRanged(boolean isRanged)
        {
            this.isRanged = isRanged;
            return this;
        }
        
        Builder strength(int strength)
        {
            this.talents.put(Talent.STRENGTH, strength);
            return this;
        }  
        
        Builder agility(int agility)
        {
            this.talents.put(Talent.AGILITY, agility);
            return this;
        }
        
        Builder intelligence(int intelligence)
        {
            this.talents.put(Talent.INTELLIGENCE, intelligence);
            return this;
        }
                
        public Hero build()
        {
            return new Hero(this); 
        }
    }


    @Override
    public int compareTo(Hero hero)
    {
        if (this.getHeight() > hero.getHeight()) 
        {
            return 1;
        } 
        else if(this.getHeight() < hero.getHeight())
        {
            return -1;
        } 
        return 0;
    }
}