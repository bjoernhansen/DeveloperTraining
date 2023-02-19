package training.basics.functionalInterface;

import training.basics.hero.Hero;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main
{
    private static final int MAX_HERO_NUMBER = 100;
    
    public static void main(String[] args)
    {
        List<Hero> heros = Hero.getHeroes(MAX_HERO_NUMBER);
    
        Map<Integer, List<Hero>> herosByHeight = heros
            .stream()
            .collect(Collectors.groupingBy(Hero::getHeight));
        
        
        herosByHeight.forEach((height, heroList) ->
                System.out.println(height + " " + heroList));
        
        
        //heros.stream()
        //.filter(h->h.getHeight()>170)
        //.map(h -> h.getName())
        //.sorted()
        //.distinct()
        //.collect(Collectors.groupingBy(null));
        //.forEach(System.out::println);
        
        /*
        TreeSet<Hero> heros2 = new TreeSet<>(new HeroHeightComperator());
        Predicate<Hero> tallHeroCheck = (h) -> h.getHeight() >= 185;
        Function<Hero, String> shoutText = h -> "Ich bin " + h.getName() + "!";
        HeroShouter heroShouter = h -> {System.out.println("Ich bin " + h.getHeight() + "cm groß!");};
        
        

        for (Hero hero: heros)
        {
            if (hero.checkMe(tallHeroCheck))
            {
                heros2.add(hero);
            }
        }

        System.out.println("Unsortiert:");
        for (Hero hero: heros)
        {
            hero.shout();
        }

        heros.sort(new HeroHeightComperator());

        System.out.println("\nSortiert:");
        for (Hero hero: heros)
        {
            hero.shout();
        }

        heros.sort(new HeroHeightComperator());

        System.out.println("\nAus TreeSet mit Anwendung des Lambda-Ausdrucks:");
        for (Hero hero: heros2)
        {
            hero.shout();
        }

        System.out.println("\n");
        for (Hero hero: heros)
        {
            System.out.println(shoutText.apply(hero));
        }

        Integer aggregatedQuantity = heros.stream().map((h) -> h.getHeight())
                .reduce(0, Integer::sum);

        System.out.println(aggregatedQuantity);
        
        */
        
        //heros2.stream().
        
        /*
        IntStream.range(1, 4)
        .forEach(System.out::println);*/
        
        
    }
}
