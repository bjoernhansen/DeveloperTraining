package training.design_pattern.prototype;

public class ConcreteClass implements Prototype
{
    private final int someValue;

    public ConcreteClass(int someValue)
    {
        this.someValue = someValue;
    }

    @Override
    public Prototype makeCopy()
    {
        return new ConcreteClass(someValue);
    }
}
