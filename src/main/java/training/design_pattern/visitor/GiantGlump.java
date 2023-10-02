package training.design_pattern.visitor;

class GiantGlump implements Glump
{
    @Override
    public void apply(Reaction reaction)
    {
        reaction.perform(this);
    }
}
