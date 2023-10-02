package training.design_pattern.simulated_inheritance;

public class SwimmingPlane extends Boat implements FlyingEntity, SwimmingEntity
{
    private final Plane
        plane = new MyPlane();

    @Override
    public void fly()
    {
        plane.fly();
    }

    @Override
    public void swim()
    {
        super.swim();
    }

    private class MyPlane extends Plane
    {

    }
}
