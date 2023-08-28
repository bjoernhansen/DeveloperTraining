package training.design_pattern.enum_factory;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

enum HeroType implements HeroFactory {
    BARBARIAN(Barbarian::new),
    ARCHER(Archer::new),
    MAGE(Mage::new),
    DWARF(Dwarf::new);

    private static final List<HeroType>
        heros;

    private static final Random
        random = new Random();

    static {
        heros = List.of(values());
    }

    private final Supplier<Hero>
        heroSupplier;

    HeroType(Supplier<Hero> heroSupplier) {
        this.heroSupplier = heroSupplier;
    }

    @Override
    public Hero makeInstance() {
        return heroSupplier.get();
    }

    static HeroType getRandomHero() {
        return heros.get(random.nextInt(heros.size()));
    }
}
