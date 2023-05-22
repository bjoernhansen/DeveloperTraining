package training.design_pattern.observer.my_observer;

import java.time.LocalDate;

/*
 * -Subjekt
 * -Observable 
 * -Datenverwalter
 */
public class Data extends MyObservable
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
			setChanged();		// Daten haben sich ge�ndert
			notifyObservers(LocalDate.now());	// "sendet" Daten
		}
	}
}
