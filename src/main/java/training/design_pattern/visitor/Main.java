package training.design_pattern.visitor;

class Main
{
    public static void main(String[] args)
    {
        GlumpZoo glumpZoo = new GlumpZoo();
        Reaction clapping = new Clapping();
        Reaction greeting = new Greeting();

        glumpZoo.execute(clapping);
        glumpZoo.execute(greeting);
    }
}
