package training.design_pattern.observer.my_observer;


import training.design_pattern.observer.my_observer.MyObservable;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;


public class Glump extends MyObservable
{
    private static final LinkedList<String>
        presents = new LinkedList<>(Arrays.asList("Football", "Pullover", "Teddy", "Chocolate", "Flowers"));

    private final String
        name;
    
    private int
        age;

    
    Glump(String name)
    {
        this.name = name;
    }


    public void becomeOlder()
    {
        this.age++;
        Collections.shuffle(presents);
        String birthdayPresent = presents.peek();
        this.setChanged();
        this.notifyObservers(birthdayPresent);
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}
