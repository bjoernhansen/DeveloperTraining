package com.observing.observer_observable;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;


public class Glump extends Observable
{
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
        this.setChanged();
        this.notifyObservers(birtdayPresent);
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}
