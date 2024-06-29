package training.basics.stream.example_models;

import java.util.Random;


abstract class AbstractFlyingObject implements FlyingObject
{
    private static final Random random = new Random();
    
    private final int id;
    
    AbstractFlyingObject()
    {
        this.id = 1 + random.nextInt(9998);
    }
    
    @Override
    public String toString()
    {
        return getClass().getSimpleName() + " mit ID " + id;
    }
}
