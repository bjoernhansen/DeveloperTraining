package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

import com.google.inject.Inject;
import com.google.inject.name.Named;


public class WeakFighter implements Fighter
{
    // field injection, not recommended
    
    @Inject
    private Shouting
        shouting;
    
    @Inject @Named("JokeWeapon")
    private Weapon
        weapon;
    
    
    private static final String
        DESCRIPTION = "weak fighter and a coward";
    
    
    @Override
    public void useWeapon()
    {
        weapon.use();
    }
    
    @Override
    public void shout()
    {
        shouting.cry();
    }
    
    @Override
    public String getDescription()
    {
        return DESCRIPTION;
    }
    
    @Override
    public boolean isHero()
    {
        return false;
    }
}
