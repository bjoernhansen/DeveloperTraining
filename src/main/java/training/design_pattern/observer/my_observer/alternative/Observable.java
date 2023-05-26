package training.design_pattern.observer.my_observer.alternative;



import java.util.ArrayList;
import java.util.List;


abstract class Observable
{
    // Warnung in der Implementierenden Klasse:
    // Unchecked overriding: return type requires unchecked conversion.
    private final List<Observer<? extends Observable>> observerList = new ArrayList<>();
    
    
    public void addObserver(Observer<? extends Observable> observer)
    {
        this.observerList.add(observer);
    }
    
    public void notifyObservers()
    {
        for(Observer<? extends Observable> observer : this.observerList)
        {
            observer.update(getIdentity());
        }
    }
    
    public abstract <T extends Observable> T getIdentity();
}