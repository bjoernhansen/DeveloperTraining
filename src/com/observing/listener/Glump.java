package com.observing.listener;


import javax.swing.event.EventListenerList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;


public class Glump
{
    private EventListenerList
            listeners = new EventListenerList();

    private static final LinkedList<String>
            presents = new LinkedList<>(Arrays.asList("Football", "Pullover", "Teddy", "Chocolate", "Flowers"));

    private String name;
    private int age;


    Glump(String name)
    {
        this.name = name;
    }

    public void becomeOlder()
    {
        this.age++;
        Collections.shuffle(presents);
        String birtdayPresent = presents.peek();
        this.notifyAdvertisement(new BirthdayEvent(this, birtdayPresent));
    }

    public void addBirtdayListener(BirtdayListener listener)
    {
        this.listeners.add(BirtdayListener.class, listener);
    }

    protected synchronized void notifyAdvertisement(BirthdayEvent event)
    {
        for(BirtdayListener listener : listeners.getListeners(BirtdayListener.class))
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
