package training.design_pattern.dependency_injection.guice.example_3_constructor_binding;

import com.google.inject.AbstractModule;


class Module extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(String.class).toInstance("Maja");
        
        try
        {
            bind(Bee.class).toConstructor(Bee.class.getConstructor(String.class));
        }
        catch(NoSuchMethodException e)
        {
            throw new RuntimeException(e);
        }
        
        bind(BeeWrapper.class).toInstance(new BeeWrapper(new Bee("Willi")));
    }
}
