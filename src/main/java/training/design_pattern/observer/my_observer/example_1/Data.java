package training.design_pattern.observer.my_observer.example_1;

import training.design_pattern.observer.my_observer.Observable;

/*
 * -Subjekt
 * -Observable
 * -Datenverwalter
 */
class Data extends Observable<Data>
{
    private static final int
        NO_OF_INCREMENTS = 6;
    
    int count = 0;
    
    
    public void incrementSeveralTimes()
    {
        for(int i = 0; i < NO_OF_INCREMENTS; i++)
        {
            this.count++;
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Observable: " + this.count);
            notifyObservers();    // "sendet" Daten
        }
    }
    
    @Override
    public Data getIdentity()
    {
        return this;
    }
}
