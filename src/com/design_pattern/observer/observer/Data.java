package com.design_pattern.observer.observer;

import java.time.LocalDate;
import java.util.Observable;

/*
 * -Subjekt
 * -Observable 
 * -Datenverwalter
 */
public class Data extends Observable
{
	
	int count=0;
	
	public void test ()
	{
		while(true)
		{
			this.count++;
			
			try{Thread.sleep(1000);} 
			catch (InterruptedException e){e.printStackTrace();}
			
			System.out.println("Observable: " + this.count);
			this.setChanged();		// Daten haben sich ge�ndert
			this.notifyObservers(LocalDate.now());	// "sendet" Daten 
			
		}
	}
}
