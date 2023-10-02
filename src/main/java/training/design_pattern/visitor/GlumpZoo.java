package training.design_pattern.visitor;

import java.util.List;


public class GlumpZoo
{
    private final List<Glump>
        glumps = List.of(new GiantGlump(), new PricklyGlump());


    void execute(Reaction reaction)
    {
        for (var glump : glumps)
        {
            glump.apply(reaction);
        }
    }
}
