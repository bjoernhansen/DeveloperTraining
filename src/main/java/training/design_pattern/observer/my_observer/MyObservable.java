package training.design_pattern.observer.my_observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyObservable 
{
	boolean stateChanged = false;
	
	private final List<MyObserver> myObserverList = new ArrayList<>();
	
	
	
	public void addObserver(MyObserver observer)
	{
		this.myObserverList.add(observer);
	}
	
	
	public void setChanged()
	{
		this.stateChanged = true;
	}
		
	public void notifyObservers()
	{
		notifyObservers(null);
	}
		
	public void notifyObservers(LocalDate now)
	{
		if(this.stateChanged)
		{
			for( MyObserver observer : this.myObserverList)
			{
				observer.update(this, now);
			}			
			this.stateChanged = false;			
		}
	}
}
