package training.design_pattern.observer.my_observer.example_1;

import training.design_pattern.observer.my_observer.Observer;

class DataObserver implements Observer<Data>
{	
	@Override
	public void update(Data data)
	{
		System.out.print("Observer: " + data.count);
	}
}
