package training.java_basics.hero;

import java.util.Random;
import java.util.function.UnaryOperator;

public class RandomNameCreator
{
    private static final String [] 
        CONSONANT = {   "b", "ch", "d", "f", "g", "h", "j", 
                        "k", "l", "m", "n", "p", "pf", "qu", 
                        "r", "s", "st", "sch", "u", "v", "w",
                        "x", "y", "z", ""},  
        VOWEL     = {   "a", "e", "i", "o", "u", "ö", "ü", 
                        "ä", "y", "au", "eu", "ei"},
        GENDER_SUFFIX = {"us", "a"};       
    
    private final Random
        random = new Random();
    
    private static final RandomNameCreator
        INSTANCE = new RandomNameCreator();
    
    private final UnaryOperator<String>
        stringFormatter = (s) -> Character.toUpperCase(s.charAt(0)) + s.substring(1);
    
    private RandomNameCreator() {}
        
    private String getName(Gender gender)
    {
        StringBuilder name = new StringBuilder();
        for(int i = 0; i < random.nextInt(2)+1; i++)
        {
            name.append(CONSONANT[random.nextInt(CONSONANT.length)]);
            name.append(VOWEL[random.nextInt(VOWEL.length)]);
        }
        name.append(CONSONANT[random.nextInt(CONSONANT.length)])
            .append(gender.getNameSuffix());
        return stringFormatter.apply(name.toString());
    }
    
    private String getName()
    {
        return getName(Gender.getRandomGender());
    }
    
    public static String createName(Gender gender){
        return INSTANCE.getName(gender);
    }
    
    public static String createName(){
        return INSTANCE.getName();
    }
}
