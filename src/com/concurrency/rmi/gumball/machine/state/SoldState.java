package com.concurrency.rmi.gumball.machine.state;

class SoldState extends AbstractState
{
	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
 
	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}
 
	@Override
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}
 
	@Override
	public void dispense() {
		releaseBallFromGumballMachine();
		if (!isGumballMachineEmpty()) {
			setGumballMachineState(StateType.NO_QUARTER);
		} else {
			System.out.println("Oops, out of gumballs!");
			setGumballMachineState(StateType.SOLD_OUT);
		}
	}
	
	@Override
	public void refill() { }
 
	public String toString() {
		return "dispensing a gumball";
	}
}


