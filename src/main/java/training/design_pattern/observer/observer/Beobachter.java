package training.design_pattern.observer.observer;

import java.util.Observable;
import java.util.Observer;

public class Beobachter implements Observer
{
	@Override
	public void update(Observable o, Object obj)
	{
		Data data = (Data) o;
		System.out.print("Beobachter: " + data.count + "\tObjekt: " + obj + "\n");	
		
				
	}
}
