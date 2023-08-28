package training.design_pattern.enum_factory;

class Archer implements Hero {
    @Override
    public void shout() {
        System.out.println("I am an Archer!");
    }
}