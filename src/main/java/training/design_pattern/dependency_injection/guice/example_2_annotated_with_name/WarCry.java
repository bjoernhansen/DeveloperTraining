package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

class WarCry implements Shouting
{
    @Override
    public void cry()
    {
        System.out.println("Woahh!");
    }
}
