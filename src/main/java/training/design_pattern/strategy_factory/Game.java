package training.design_pattern.strategy_factory;

import java.util.Random;

public class Game
{
    public static VerhaltenTyp randomTyp()
    {
        return VerhaltenTyp.values()[new Random().nextInt(VerhaltenTyp.values().length)];
    }
    
    public static void main(String[] args)
    {
        Gegner g = new Gegner(new StandardVerhalten());
        
        while (true)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            g.setVerhalten(Factory.create(randomTyp()));
            g.go();
        }
    }
}
