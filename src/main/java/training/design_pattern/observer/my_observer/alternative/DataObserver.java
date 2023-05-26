package training.design_pattern.observer.my_observer.alternative;



class DataObserver implements Observer<Data>
{	
	@Override
	public void update(Data data)
	{
		System.out.print("Observer: " + data.getCount());
	}
}
