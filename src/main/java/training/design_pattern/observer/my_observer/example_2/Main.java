package training.design_pattern.observer.my_observer.example_2;

class Main
{
    public static void main(String[] args)
    {
        Glump timo = new Glump("Timo");
        GlumpPrinter glumpPrinter = new GlumpPrinter(timo);

        timo.addObserver(glumpPrinter);

        System.out.println(glumpPrinter);

        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();

        System.out.println(glumpPrinter);
    }
}