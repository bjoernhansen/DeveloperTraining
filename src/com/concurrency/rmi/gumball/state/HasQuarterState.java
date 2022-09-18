package com.concurrency.rmi.gumball.state;


class HasQuarterState extends AbstractState {
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}
 
	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		setGumballMachineState(StateType.NO_QUARTER);
	}
 
	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		setGumballMachineState(StateType.SOLD);
	}

    @Override
	public void dispense() {
        System.out.println("No gumball dispensed");
    }
    
    @Override
	public void refill() { }
	
	public String toString() {
		return "waiting for turn of crank";
	}
}
