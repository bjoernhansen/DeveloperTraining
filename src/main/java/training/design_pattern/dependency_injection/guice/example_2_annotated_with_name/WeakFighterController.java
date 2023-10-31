package training.design_pattern.dependency_injection.guice.example_2_annotated_with_name;

import com.google.inject.Inject;
import com.google.inject.name.Named;


record WeakFighterController(Fighter fighter) implements FighterController
{
    @Inject
    WeakFighterController(@Named("Weakling") Fighter fighter)
    {
        this.fighter = fighter;
    }
}
