package training.concurrency.threads;


public class Anonym {

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Runnable()
		{			
			@Override
			public void run()
			{				
				
			}
		});
		
		// Lambda 
		Thread t2 = new Thread(()->{});
		t2.start();	 // Fehlerquelle: vergessen zu starten
	}
}
