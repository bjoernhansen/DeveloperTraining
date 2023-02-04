package training.test_examples.custom_assertion;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import training.test_examples.test_data.AnimalType;
import training.test_examples.test_data.StuffedAnimal;

public class StuffedAnimalAssert extends AbstractAssert<StuffedAnimalAssert, StuffedAnimal>
{
    protected StuffedAnimalAssert(StuffedAnimal stuffedAnimal)
    {
        super(stuffedAnimal, StuffedAnimalAssert.class);
    }
    
    public StuffedAnimalAssert isTeddy()
    {
        Assertions.assertThat(actual.getAnimalType()).isEqualTo(AnimalType.BEAR);
        return this;
    }
    
    public static StuffedAnimalAssert assertThat(StuffedAnimal stuffedAnimal)
    {
        return new StuffedAnimalAssert(stuffedAnimal);
    }
}
