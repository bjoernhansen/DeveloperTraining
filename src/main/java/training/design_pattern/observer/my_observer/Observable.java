package training.design_pattern.observer.my_observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable <T extends Observable<?>>
{
	private final List<Observer<T>> observerList = new ArrayList<>();
	
	
	public void addObserver(Observer<T> observer)
	{
		this.observerList.add(observer);
	}
	
	public void notifyObservers()
	{
		for( Observer<T> observer : this.observerList)
		{
			observer.update(getIdentity());
		}
	}
	
	public abstract T getIdentity();
}
