package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

class WarHammer implements Weapon
{
    @Override
    public void use()
    {
        System.out.println("SMASH!!!");
    }
}
