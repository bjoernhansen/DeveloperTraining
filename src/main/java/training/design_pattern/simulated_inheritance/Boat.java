package training.design_pattern.simulated_inheritance;

public abstract class Boat implements SwimmingEntity
{
    @Override
    public void swim()
    {
        // very much complex code
        System.out.println("swimming");
    }
}
