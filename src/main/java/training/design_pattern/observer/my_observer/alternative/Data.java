package training.design_pattern.observer.my_observer.alternative;

class Data extends Observable
{
    private static final int
        NO_OF_INCREMENTS = 3;
    
    private int
        count = 0;
    
    
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
    
    public int getCount()
    {
        return count;
    }
    
    @Override
    public <T extends Observable> T getIdentity()
    {
        // TODO get rid of unchecked warning
        return null;
        // return (T) this;
    }
}
