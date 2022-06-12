package com.java_basics.stream.object_output_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main
{
	public static void main(String[] args)  //throws PupsiException 
	{
		FlyingObject[] objects = new FlyingObject[10];
		
		objects[1] = new FliegendeUntertasse();
		objects[2] = new Flugzeug();
		
		
		FlyingObject test = objects[1];
		
		System.out.println(test.getClass());
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/basics/stream/object_output_stream/test.txt")))
		{
			oos.writeObject(objects[2]);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}