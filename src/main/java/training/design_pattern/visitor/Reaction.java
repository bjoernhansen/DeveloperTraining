package training.design_pattern.visitor;

// The visitor
interface Reaction
{
    void perform(PricklyGlump pricklyGlump);

    void perform(GiantGlump giantGlump);
}
