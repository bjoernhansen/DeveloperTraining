package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

import com.google.inject.Guice;
import com.google.inject.Injector;


class Main
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new BasicModule());
        
        System.out.println("first fighter:");
        StrongFighterController strongFighterController = injector.getInstance(StrongFighterController.class);
        strongFighterController.startFighterAction();
        StrongFighterController anotherStrongFighterController = injector.getInstance(StrongFighterController.class);
        System.out.println("Singleton? " + (strongFighterController.fighter() == anotherStrongFighterController.fighter()));
        
        System.out.println();
        
        System.out.println("second fighter");
        WeakFighterController weakFighterController = injector.getInstance(WeakFighterController.class);
        weakFighterController.startFighterAction();
        WeakFighterController anotherWeakFighterController = injector.getInstance(WeakFighterController.class);
        System.out.println("Singleton? " + (weakFighterController.fighter() == anotherWeakFighterController.fighter()));
    
        System.out.println();
        
        System.out.println("third fighter");
        DancingFighterController dancingFighterController = injector.getInstance(DancingFighterController.class);
        dancingFighterController.startFighterAction();
        DancingFighterController anotherDancingFighterController = injector.getInstance(DancingFighterController.class);
        System.out.println("Singleton? " + (dancingFighterController.fighter() == anotherDancingFighterController.fighter()));
    }
}
