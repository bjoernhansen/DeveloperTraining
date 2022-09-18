package com.concurrency.rmi.gumball.state;

import com.concurrency.rmi.gumball.GumballMachine;

abstract class AbstractState implements State
{
    private GumballMachine
        gumballMachine;
    
    
    void releaseBallFromGumballMachine()
    {
        gumballMachine.releaseBall();
    }
    
    boolean isGumballMachineEmpty()
    {
        return  gumballMachine.getCount() <= 0;
    }
    
    protected void setGumballMachineState(StateType stateType)
    {
        this.gumballMachine.setState(stateType);
    }
    
    @Override
    public void setGumballMachine(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }
}
