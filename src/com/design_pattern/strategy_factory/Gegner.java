package com.design_pattern.strategy_factory;

public class Gegner
{
    private Verhalten verhalten;
    
    
    public Gegner(Verhalten verhalten)
    {
        super();
        this.verhalten = verhalten;
    }
    
    public void setVerhalten(Verhalten verhalten)
    {
        this.verhalten = verhalten;
    }
    
    public void go()
    {
        this.verhalten.go();
    }
    
}
