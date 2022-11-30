package training.concurrency.rmi.gumball.machine;

import training.concurrency.rmi.gumball.machine.state.StateType;

public interface GumballMachine
{
    void insertQuarter();
    
    void ejectQuarter();
    
    void turnCrank();
    
    void releaseBall();
    
    void refill(int count);
    
    void setState(StateType stateType);
    
    int getCount();
}
