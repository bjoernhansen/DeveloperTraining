package training.design_pattern.visitor;

class Greeting implements Reaction
{
    @Override
    public void perform(PricklyGlump pricklyGlump)
    {
        System.out.println("Prickly Glump is greeting!");
    }

    @Override
    public void perform(GiantGlump giantGlump)
    {
        System.out.println("GiantGlump is greeting!");
    }
}
