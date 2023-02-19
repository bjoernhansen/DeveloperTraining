package training.basics.hero;

import training.utilities.Calculations;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hero implements Comparable<Hero>
{
    private static final Comparator<Hero>
        COMPARATOR = Comparator.comparingInt(Hero::getHeight)
                               .thenComparing(Hero::getName)
                               .thenComparing(Object::hashCode);
    
    private static final Random
        random = new Random();
    
    
    private final String
        name;
    
    private final Gender
        gender;
    
    private final int
        height;
    
    private final boolean
        isRanged;
    
    private final Map<Talent, Integer>
        talents = new EnumMap<>(Talent.class);
    
    
    public static Hero newInstance(){
        return new Hero();
    }
    
    private Hero()
    {
        this.gender = Gender.getRandomGender();
        this.name = RandomNameCreator.createName(this.gender);
        this.height = this.gender.randomHeight();
        this.isRanged = Calculations.tossUp();
        Talent.getValues()
              .forEach(talent -> talents.put(talent, Talent.getRandomValue()));
    }
    
    public static List<Hero> getHeroes(int numberOfHeroes){
        return Stream.generate(Hero::newInstance)
                     .limit(numberOfHeroes)
                     .collect(Collectors.toList());
    }
    
    public String getName()
    {
        return name;
    }
    
    public Gender getGender()
    {
        return gender;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getStrength()
    {
        return this.talents.get(Talent.STRENGTH);
    }
    
    public int getAgility()
    {
        return this.talents.get(Talent.AGILITY);
    }
    
    public int getIntelligence()
    {
        return this.talents.get(Talent.INTELLIGENCE);
    }
    
    
    public void announcement(){
        Gender gender = getGender();
        System.out.printf("%s %s, %s %s%n", gender.getTitle(), getName(), gender.getArticle(), gender.getDescription());
    }
    
    public boolean checkMe(Predicate<Hero> checkFunction)
    {
        return checkFunction.test(this);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s %s (%d cm groß)", gender.getTitle(), name, height);
    }
    
  
    
    @Override
    public int compareTo(Hero otherHero)
    {
        return COMPARATOR.compare(this, otherHero);
    }
}
