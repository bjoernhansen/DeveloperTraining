package training.design_pattern.composite;

class Leaf implements Component
{
    private final String name;

    Leaf(String name)
    {
        this.name = name;
    }

    @Override
    public void render()
    {
        System.out.println("Rendered " + name + "!");
    }
}
