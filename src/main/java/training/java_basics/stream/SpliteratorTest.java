package training.java_basics.stream;

import training.java_basics.hero.Hero;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorTest
{
    public static void main(String[] args)
    {
        List<Hero> heroList = Hero.getHeroes(100);

        if (false)
        {
            // printing out hero height, usage of map function
            heroList.stream()
                    .map(Hero::getHeight)
                    .forEach(System.out::println);
        }

        Spliterator<Hero> heros1 = Hero.getHeroes(10).spliterator();
        Spliterator<Hero> heros2 = heros1.trySplit();
    
        System.out.println("heros1");
        heros1.forEachRemaining(Hero::announcement);
        System.out.println("\nheros2 - die ersten zwei");
        heros2.tryAdvance(Hero::announcement);
        heros2.tryAdvance(Hero::announcement);
    
        
        
        
        
        
    
        System.out.println("\nheros2 - die Fehlenden");
        heros2.forEachRemaining(Hero::announcement);
    }
}
