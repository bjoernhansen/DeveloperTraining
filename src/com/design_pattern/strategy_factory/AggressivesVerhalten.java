package com.design_pattern.strategy_factory;

public class AggressivesVerhalten implements Verhalten
{
    @Override
    public void go()
    {
        System.out.println("AggressivesVerhalten...");
    }
}
