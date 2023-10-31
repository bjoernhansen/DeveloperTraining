package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

import com.google.inject.Inject;
import com.google.inject.name.Named;


public class DancingFighter implements Fighter
{
    // method injection
    
    private Shouting
        shouting;
    
    private Weapon
        weapon;
    
    private Boolean
        isHero;
    
    
    private static final String
        DESCRIPTION = "dancing fighter";
    

    
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
    
    @Inject
    public void setShouting(Shouting shouting)
    {
        this.shouting = shouting;
    }
    
    @Inject
    public void setWeapon(@Named("StrongWeapon") Weapon weapon)
    {
        this.weapon = weapon;
    }
    
    @Inject
    public void setHero(Boolean hero)
    {
        isHero = hero;
    }
}
