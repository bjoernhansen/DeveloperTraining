package training.design_pattern.observer.my_observer;

public class Beobachter implements MyObserver
{	
	@Override
	public void update(MyObservable o, Object obj)
	{
		Data data = (Data) o;
		System.out.print("Beobachter: " + data.count + "\tObjekt: " + obj + "\n");	
	}
}
