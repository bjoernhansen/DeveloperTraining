package com.concurrency.rmi.gumball.machine.state;


import com.concurrency.rmi.gumball.machine.GumballMachine;

import java.io.Serializable;

public interface State extends Serializable
{
	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	void dispense();
	
	void refill();
	
	void setGumballMachine(GumballMachine gumballMachine);
}
