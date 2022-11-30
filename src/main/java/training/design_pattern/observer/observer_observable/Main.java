package training.design_pattern.observer.observer_observable;

public class Main
{
    public static void main(String[] args)
    {
        Glump timo = new Glump("Timo");
        GlumPrinter glumPrinter = new GlumPrinter(timo);

        timo.addObserver(glumPrinter);

        System.out.println(glumPrinter);

        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();

        System.out.println(glumPrinter);
    }
}