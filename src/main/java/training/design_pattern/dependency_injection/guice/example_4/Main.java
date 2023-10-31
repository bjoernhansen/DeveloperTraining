package training.design_pattern.dependency_injection.guice.example_4;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class Main
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new Module());
        Communicator communication = injector.getInstance(Communicator.class);
        
        communication.sendMessage("Hello!");
    }
}
