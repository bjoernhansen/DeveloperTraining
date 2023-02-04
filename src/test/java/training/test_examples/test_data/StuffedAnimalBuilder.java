package training.test_examples.test_data;

import javafx.scene.paint.Color;

public class StuffedAnimalBuilder
{
    private static final String
        DEFAULT_BEAR_NAME = "Bruno";
    
    private static final double
        DEFAULT_SIZE = 24.0;

    
    
    private final String
        name;
    
    private AnimalType
        animalType = AnimalType.LION;
    
    private Color
        color = Color.RED;
    
    private double
        size;
    
    
    public static StuffedAnimal makeDefaultTeddy()
    {
        return new StuffedAnimalBuilder(DEFAULT_BEAR_NAME).colored(Color.BROWN)
                                                          .species(AnimalType.BEAR)
                                                          .size(DEFAULT_SIZE)
                                                          .build();
    }
    
    public static StuffedAnimalBuilder aStandardSizedStuffedAnimal(String name)
    {
        return new StuffedAnimalBuilder(name).size(DEFAULT_SIZE);
    }
    
    private StuffedAnimalBuilder(String name)
    {
        this.name = name;
    }
    
    StuffedAnimalBuilder species(AnimalType animalType)
    {
        this.animalType = animalType;
        return this;
    }
    
    StuffedAnimalBuilder colored(Color color)
    {
        this.color = color;
        return this;
    }
    
    StuffedAnimalBuilder size(double size)
    {
        this.size = size;
        return this;
    }
    
    StuffedAnimalBuilder but()
    {
        return new StuffedAnimalBuilder(name).size(size)
                                             .species(animalType)
                                             .colored(color);
    }
    
    public StuffedAnimal build()
    {
        return new StuffedAnimal(name, animalType, color, size);
    }
}

