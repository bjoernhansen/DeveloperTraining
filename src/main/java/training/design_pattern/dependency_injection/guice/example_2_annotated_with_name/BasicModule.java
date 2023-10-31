package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;


class BasicModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Boolean.class).toInstance(true);
        
        bind(Fighter.class)
            .annotatedWith(Names.named("StrongFighter"))
            .to(Warrior.class).in(Scopes.SINGLETON); // lazy instantiation
        
        bind(Fighter.class)
            .annotatedWith(Names.named("Weakling"))
            .to(WeakFighter.class);
        
        bind(Fighter.class)
            .annotatedWith(Names.named("DancingFighter"))
            .to(DancingFighter.class).asEagerSingleton(); // eager instantiation
        
        bind(Fighter.class)
            .annotatedWith(Names.named("Weakling"))
            .to(WeakFighter.class);
        
        // eindeutig, daher "annotatedWith" nicht erforderlich
        bind(Shouting.class).to(WarCry.class);
        
        bind(Weapon.class)
            .annotatedWith(Names.named("StrongWeapon"))
            .to(WarHammer.class);
        
        bind(Weapon.class)
            .annotatedWith(Names.named("JokeWeapon"))
            .to(Spoon.class);
        
        
    }
}
