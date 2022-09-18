package com.concurrency.rmi.gumball.state;



import com.concurrency.rmi.gumball.GumballMachine;

import java.util.EnumMap;

public class StateProvider
{
    private final EnumMap<StateType, State>
        states = new EnumMap<>(StateType.class);
        
    public StateProvider(GumballMachine gumballMachine)
    {
        StateType.getValues().forEach(stateType -> {
            State state = stateType.makeInstance();
            state.setGumballMachine(gumballMachine);
            states.put(stateType, state);
        });
    }
    
    public State getState(StateType stateType)
    {
        return states.get(stateType);
    }
    
    public void setGumballMachine(GumballMachine gumballMachine)
    {
        StateType.getValues().forEach(
            stateType -> states.get(stateType).setGumballMachine(gumballMachine));
    }
}
