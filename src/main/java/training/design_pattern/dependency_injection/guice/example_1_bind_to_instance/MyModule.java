package training.design_pattern.dependency_injection.guice.example_1_bind_to_instance;


import com.google.inject.AbstractModule;
import com.google.inject.name.Names;


public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("message")).toInstance("Hello, Guice!");
    }
}
