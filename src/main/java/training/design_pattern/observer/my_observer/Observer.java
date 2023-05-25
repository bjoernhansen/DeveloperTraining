package training.design_pattern.observer.my_observer;

public interface Observer <T extends Observable<?>>
{
	void update(T observable);
}
