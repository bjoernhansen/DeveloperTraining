package training.design_pattern.observer.my_observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyObservable 
{
	private boolean stateChanged = false;
	
	private final List<MyObserver> myObserverList = new ArrayList<>();
	
	
	
	public void addObserver(MyObserver observer)
	{
		this.myObserverList.add(observer);
	}
	
	
	public void setChanged()
	{
		this.stateChanged = true;
	}
	
	public void notifyObservers(Object obj)
	{
		if(this.stateChanged)
		{
			for( MyObserver observer : this.myObserverList)
			{
				observer.update(this, obj);
			}			
			this.stateChanged = false;			
		}
	}
}
