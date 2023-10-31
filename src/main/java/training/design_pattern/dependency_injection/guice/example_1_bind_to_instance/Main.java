package training.design_pattern.dependency_injection.guice.example_1_bind_to_instance;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyModule());
        MyClass myClass = injector.getInstance(MyClass.class);
        myClass.sayHello();
    }
}
