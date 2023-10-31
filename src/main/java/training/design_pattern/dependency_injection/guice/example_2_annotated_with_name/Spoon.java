package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

public class Spoon implements Weapon
{
    @Override
    public void use()
    {
        System.out.println("Pling!");
    }
}
