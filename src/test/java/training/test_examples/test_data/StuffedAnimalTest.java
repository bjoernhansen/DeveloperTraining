package training.test_examples.test_data;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import training.test_examples.custom_assertion.StuffedAnimalAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class StuffedAnimalTest
{
    
    @Test
    void chainedAssertionsTest()
    {
        StuffedAnimalBuilder stuffedLionBuilder = StuffedAnimalBuilder.aStandardSizedStuffedAnimal("Leo")
                                                                      .species(AnimalType.LION)
                                                                      .colored(Color.YELLOW);
        
        StuffedAnimal standardLion = stuffedLionBuilder.build();
        StuffedAnimal hugeLion = stuffedLionBuilder.but().size(36.0).build();
        StuffedAnimal blackLion = stuffedLionBuilder.but().colored(Color.BLACK).build();
    
        StuffedAnimal teddy = StuffedAnimalBuilder.makeDefaultTeddy();
        
        assertThat(teddy.color()).isEqualTo(Color.BROWN);
        assertThat(hugeLion.name()).isEqualTo(blackLion.name());
        
        StuffedAnimalAssert.assertThat(teddy).isTeddy();
    }
}
