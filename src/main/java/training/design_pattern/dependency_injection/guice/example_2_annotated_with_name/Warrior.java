package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

import com.google.inject.Inject;
import com.google.inject.name.Named;


class Warrior implements Fighter
{
    // constructor injection
    
    private Shouting
        shouting;
    
    private Weapon
        weapon;
    
    private Boolean
        isHero;
    
    
    private static final String
        DESCRIPTION = "really strong fighter";
    
    
    @Inject
    public Warrior(Shouting shouting,
                   @Named("StrongWeapon") Weapon weapon,
                   boolean isHero)
    {
        this.shouting = shouting;
        this.weapon = weapon;
        this.isHero = isHero;
    }
    
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
        return isHero;
    }
}
