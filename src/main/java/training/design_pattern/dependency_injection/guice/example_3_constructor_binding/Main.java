package training.design_pattern.dependency_injection.guice.example_3_constructor_binding;

import com.google.inject.Guice;
import com.google.inject.Injector;


class Main
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new Module());
        Bee bee = injector.getInstance(Bee.class);
        bee.shout();
        
        BeeWrapper beeWrapper1 = injector.getInstance(BeeWrapper.class);
        BeeWrapper beeWrapper2 = injector.getInstance(BeeWrapper.class);
        
        beeWrapper1.setName("Klaus");
        beeWrapper2.info();
    }
}
