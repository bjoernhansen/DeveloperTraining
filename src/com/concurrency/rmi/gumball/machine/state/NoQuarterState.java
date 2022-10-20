package com.concurrency.rmi.gumball.machine.state;

class NoQuarterState extends AbstractState
{
	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		setGumballMachineState(StateType.HAS_QUARTER);
	}
 
	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}
 
	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
 
	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	} 
	
	@Override
	public void refill() { }
 
	public String toString() {
		return "waiting for quarter";
	}
}
