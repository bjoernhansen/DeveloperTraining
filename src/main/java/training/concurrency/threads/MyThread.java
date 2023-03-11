package training.concurrency.threads;

/*
 * Variante 1) Thread erweitern
 */


public class MyThread extends Thread
{
	private static final int SLEEP_TIME_IN_MS = 350;
	
	private boolean stop = false;
	
	
	private int i = 0;
	
	/* 
	 * Ein Thread läuft so lange wie seine run-Methode läuft
	 */
	@Override
	public void run() 
	{
		while(!this.stop)
		{
			i++;
			System.out.println(this.getName() + ": " + i);
			sleep();
		}		
	// Thread Ende	
	}
	
	private static void sleep()
	{
		try 
		{
			Thread.sleep(SLEEP_TIME_IN_MS);
		} 
		catch (InterruptedException e) 
		{				
			e.printStackTrace();
		}
	}
	
	public void stopThread()
	{
		this.stop = true;
	}
	
	
	public static void main(String[] args) 
	{
		Thread 
			t1 = new MyThread(),
			t2 = new MyThread(),
			t3 = new MyThread();
			
		t1.start();		// ruft indirekt run() auf
		t2.start();	
		t3.start();	
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
	}
}
