package training.design_pattern.dependency_injection.guice.example_1_bind_to_instance;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MyClass {
    private String
        message;
    
    @Inject
    public MyClass(@Named("message") String message) {
        this.message = message;
    }
    
    public void sayHello() {
        System.out.println(message);
    }
}
