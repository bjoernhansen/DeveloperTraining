package com.javafx.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
public class MyService extends Service<String>{

// Service == Thread
	@Override
	protected Task<String> createTask() {
		Task<String> task = new Task<>()
		{
			@Override
			protected String call()
			{
				if (isCancelled())
				{
					return "cancel...";
				}
				updateMessage("call...");
				final long MAX = 10_000_000;
				long result = 0;
				for (int i = 0; i <= MAX; i++)
				{
					result += i;
					updateValue("" + result);// Zwischenergebnis
					updateProgress(i, MAX);// Fortschritt
				}
				updateMessage("call end...");
				return "Result: " + result;  // value
			}
		};
		return task;
	}
}
