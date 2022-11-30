package training.concurrency.rmi.gumball.machine.state;

import training.concurrency.rmi.gumball.machine.GumballMachine;

abstract class AbstractState implements State
{
    private transient GumballMachine
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
