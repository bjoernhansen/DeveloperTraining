package training.test_examples.test_data;

import javafx.scene.paint.Color;


public class StuffedAnimal
{
    private final String
        name;
    
    private final AnimalType
        animalType;
    
    private final Color
        color;
    
    private final double
        size;
    
    
    public StuffedAnimal(String name, AnimalType animalType, Color color, double size)
    {
        this.name = name;
        this.animalType = animalType;
        this.color = color;
        this.size = size;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public double getSize()
    {
        return size;
    }
    
    public String getName()
    {
        return name;
    }
    
    public AnimalType getAnimalType()
    {
        return animalType;
    }
}
