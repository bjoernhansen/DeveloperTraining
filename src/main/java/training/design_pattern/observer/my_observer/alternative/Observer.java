package training.design_pattern.observer.my_observer.alternative;


interface Observer<T extends Observable>
{
	void update(T observable);
}
