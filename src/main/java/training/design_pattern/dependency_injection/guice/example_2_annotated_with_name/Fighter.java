package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

interface Fighter
{
    void useWeapon();
    
    void shout();
    
    default void introduce()
    {
        System.out.println("I am a " + getDescription() + "!");
    };
    
    String getDescription();
    
    boolean isHero();
}
