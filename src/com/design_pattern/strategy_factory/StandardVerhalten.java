package com.design_pattern.strategy_factory;

public class StandardVerhalten implements Verhalten
{
    @Override
    public void go()
    {
        System.out.println("StandardVerhalten...");
    }
}
