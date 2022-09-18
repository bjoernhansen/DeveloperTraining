package com.concurrency.rmi.gumball;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachineImplementation(2);

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		
		gumballMachine.ejectQuarter();
		gumballMachine.insertQuarter();
		
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		gumballMachine.refill(5);
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
