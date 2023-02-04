package training.test_examples.test_data;

import javafx.scene.paint.Color;


public class StuffedAnimalObjectMother
{
    private static StuffedAnimal makeDefaultTeddy()
    {
        return new StuffedAnimal("Bruno", AnimalType.BEAR, Color.BROWN, 24.0);
    }
    
    private static StuffedAnimal makeDefaultLion()
    {
        return new StuffedAnimal("Leo", AnimalType.LION, Color.YELLOW, 24.0);
    }
}
