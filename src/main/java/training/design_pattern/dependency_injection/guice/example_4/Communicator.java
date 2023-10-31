package training.design_pattern.dependency_injection.guice.example_4;

import com.google.inject.Inject;


public class Communicator
{
    @Inject
    private ScreenPrinter screenPrinter;
    
    public void sendMessage(String message)
    {
        screenPrinter.print(message);
    }
}
