package training.design_pattern.dependency_injection.guice.example_3_constructor_binding;

public class BeeWrapper
{
    private final Bee
        bee;
    
    
    public BeeWrapper(Bee bee)
    {
        this.bee = bee;
    }
    
    void info()
    {
        bee.shout();
    }
    
    void setName(String name)
    {
        bee.setName(name);
    }
}
