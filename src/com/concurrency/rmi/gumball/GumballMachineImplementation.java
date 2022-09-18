package com.concurrency.rmi.gumball;

import com.concurrency.rmi.gumball.state.State;
import com.concurrency.rmi.gumball.state.StateProvider;
import com.concurrency.rmi.gumball.state.StateType;

class GumballMachineImplementation implements GumballMachine
{
	int count;
	
	State state;
	
	StateProvider stateProvider;
 
	public GumballMachineImplementation(int numberGumballs)
	{
		count = numberGumballs;
		stateProvider = new StateProvider(this);
 		if (numberGumballs > 0) {
			state = stateProvider.getState(StateType.NO_QUARTER);
		} else {
			state = stateProvider.getState(StateType.SOLD_OUT);
		}
	}
 
	@Override
	public void insertQuarter() {
		state.insertQuarter();
	}
 
	@Override
	public void ejectQuarter() {
		state.ejectQuarter();
	}
 
	@Override
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
 
	@Override
	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count > 0) {
			count = count - 1;
		}
	}
 
	@Override
	public int getCount() {
		return count;
	}
 
	@Override
	public void refill(int count) {
		this.count += count;
		System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
		state.refill();
	}

	@Override
	public void setState(StateType stateType) {
		this.state = stateProvider.getState(stateType);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: ");
		result.append(count);
		result.append(" gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is ");
		result.append(state);
		result.append("\n");
		return result.toString();
	}
}
