package training.design_pattern.enum_factory;


class Main {
    private static final int
            NUMBER_OF_HEROS = 15;

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_HEROS; i++) {
            HeroType.getRandomHero().makeInstance().shout();
        }
    }
}
