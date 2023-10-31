package training.design_pattern.dependency_injection.guice.example_3_constructor_binding;

public class Bee
{
    private String
        name;
    
    
    public Bee(boolean isMaja)
    {
        name = isMaja ? "Maja" : "unknown";
    }
    
    public Bee(String name)
    {
        this.name = name;
    }
    
    void shout()
    {
        System.out.println("I am " + name + "!");
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
