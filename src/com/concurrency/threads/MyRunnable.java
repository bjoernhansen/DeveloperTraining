package com.concurrency.threads;

public class MyRunnable implements Runnable
{
	@Override
	public void run()
	{
		while(true)
		{
			System.out.print("run...");
			sleep(350);
		}
	}
	
	
	private static void sleep(int ms)
	{
		try 
		{
			Thread.sleep(ms);
		} 
		catch (InterruptedException e) 
		{				
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new MyRunnable());   // häufiger Fehler hier: new MyRunnable() nicht übergeben
		t1.start();
	}

}
