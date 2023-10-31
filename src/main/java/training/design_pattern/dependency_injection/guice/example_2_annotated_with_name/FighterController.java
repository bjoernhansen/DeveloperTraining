package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

public interface FighterController
{
    default void startFighterAction()
    {
        fighter().introduce();
        fighter().shout();
        fighter().useWeapon();
        System.out.println(fighter().isHero() ? "I am a hero!" : "");
        
    }
    
    Fighter fighter();
}
