package training.design_pattern.observer.observer;

import java.time.LocalDate;
import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/*
 * -Subjekt
 * -Observable 
 * -Datenverwalter
 */
public class Data extends Observable
{
	private final int
		MAX_COUNT = 0;
	
	int count=0;
	
	public void test ()
	{
		while(count < MAX_COUNT)
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
