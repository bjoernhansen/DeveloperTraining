package training.design_pattern.observer.my_observer.example_2;

import training.design_pattern.observer.my_observer.Observer;


class GlumpPrinter implements Observer<Glump>
{
    private final String name;
    
    private int age;
    
    private String lastBirthdayPresent;
    
    
    GlumpPrinter(Glump glump)
    {
        this.name = glump.getName();
        this.age = glump.getAge();
        this.lastBirthdayPresent = glump.getCurrentPresent();
    }
    
    @Override
    public String toString()
    {
        return String.format("My %d year old glump's name is %s and my last birthday present was %s.", this.age, this.name, this.lastBirthdayPresent);
    }
    
    @Override
    public void update(Glump glump)
    {
        this.age = glump.getAge();
        this.lastBirthdayPresent = glump.getCurrentPresent();
    }
}
