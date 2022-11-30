package training.design_pattern.observer.my_observer;

public class Test {

	public static void main(String[] args)
	{
		Data d = new Data();
		Beobachter b1 = new Beobachter();
		d.addObserver(b1); // Beobachter registrieren
		d.test();
	}
}
