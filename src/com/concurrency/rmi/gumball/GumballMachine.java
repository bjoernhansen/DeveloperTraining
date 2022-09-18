package com.concurrency.rmi.gumball;

import com.concurrency.rmi.gumball.state.StateType;

public interface GumballMachine
{
    void insertQuarter();
    
    void ejectQuarter();
    
    void turnCrank();
    
    void releaseBall();
    
    int getCount();
    
    void refill(int count);
    
    void setState(StateType stateType);
}
