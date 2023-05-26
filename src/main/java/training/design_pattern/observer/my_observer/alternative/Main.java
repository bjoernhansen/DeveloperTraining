package training.design_pattern.observer.my_observer.alternative;

class Main
{
    public static void main(String[] args)
    {
        Data data = new Data();
        DataObserver dataObserver = new DataObserver();
        data.addObserver(dataObserver); // Beobachter registrieren
        data.incrementSeveralTimes();
    }
}
