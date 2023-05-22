package training.design_pattern.observer.my_observer;


public class GlumPrinter implements MyObserver
{
    private final String name;
    private int age;
    private String lastBirthdayPresent;


    GlumPrinter(Glump glump)
    {
        this.name = glump.getName();
        this.age = glump.getAge();
    }

    @Override
    public String toString()
    {
        return String.format("My %d year old glump's name is %s and my last birthday present was %s.", this.age, this.name, this.lastBirthdayPresent);
    }
    
    @Override
    public void update(MyObservable o, Object obj)
    {
        Glump glump = ((Glump)o);
        this.age = glump.getAge();
        this.lastBirthdayPresent = (String)obj;
    }
}
