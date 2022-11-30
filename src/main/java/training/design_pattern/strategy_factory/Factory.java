package training.design_pattern.strategy_factory;

import java.util.HashMap;
import java.util.Map;

public class Factory
{
    public static Verhalten create(VerhaltenTyp typ)
    {
        Map<VerhaltenTyp, Verhalten> map = new HashMap<>();
        map.put(VerhaltenTyp.STANDARDVERHALTEN, new StandardVerhalten());
        map.put(VerhaltenTyp.NEUGIERIG, new NeugierigesVerhalten());
        map.put(VerhaltenTyp.AGGRESSIV, new AggressivesVerhalten());
        return map.get(typ);
    }
}
