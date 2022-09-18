package com.concurrency.rmi.gumball.state;


import com.concurrency.rmi.gumball.GumballMachine;

public interface State
{
	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	void dispense();
	
	void refill();
	
	void setGumballMachine(GumballMachine gumballMachine);
}
