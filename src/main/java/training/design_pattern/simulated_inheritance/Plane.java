package training.design_pattern.simulated_inheritance;

public abstract class Plane implements FlyingEntity
{
    @Override
    public void fly()
    {
        // very much complex code
        System.out.println("flying");
    }
}
