package training.basics.hero;

import training.utilities.Calculations;

import java.util.List;

public enum Talent
{
    STRENGTH, AGILITY, INTELLIGENCE;
    
    
    private static final List<Talent>
        VALUES = List.of(values());
    
    public static List<Talent> getValues()
    {
        return VALUES;
    }
    
    public static int getRandomValue()
    {
        int talentValue = Calculations.randomIntValue(6) + 8;
        if(talentValue >= 13){
            while(Math.random() < 0.3)
            {
                talentValue++;
            }
        }
        return talentValue;
    }
}
