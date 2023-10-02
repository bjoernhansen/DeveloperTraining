package training.design_pattern.visitor;

class Clapping implements Reaction
{
    @Override
    public void perform(PricklyGlump pricklyGlump)
    {
        System.out.println("PricklyGlump claps!");
    }

    @Override
    public void perform(GiantGlump giantGlump)
    {
        System.out.println("GiantGlump claps!");
    }
}
