package training.design_pattern.visitor;

class PricklyGlump implements Glump
{
    @Override
    public void apply(Reaction reaction)
    {
        reaction.perform(this);
    }
}
