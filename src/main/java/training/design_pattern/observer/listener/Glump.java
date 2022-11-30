package training.design_pattern.observer.listener;


import javax.swing.event.EventListenerList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class Glump
{
    private final EventListenerList
            listeners = new EventListenerList();

    private static final LinkedList<String>
            presents = new LinkedList<>(Arrays.asList("Football", "Pullover", "Teddy", "Chocolate", "Flowers"));

    private final String name;
    private int age;


    Glump(String name)
    {
        this.name = name;
    }

    public void becomeOlder()
    {
        this.age++;
        Collections.shuffle(presents);
        String birthdayPresent = presents.peek();
        this.notifyAdvertisement(new BirthdayEvent(this, birthdayPresent));
    }

    void addBirthdayListener(BirthdayListener listener)
    {
        this.listeners.add(BirthdayListener.class, listener);
    }

    private synchronized void notifyAdvertisement(BirthdayEvent event)
    {
        for(BirthdayListener listener : listeners.getListeners(BirthdayListener.class))
        {
            listener.gifting(event);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
