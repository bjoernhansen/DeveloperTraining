package training.design_pattern.observer.my_observer.example_2;


import training.design_pattern.observer.my_observer.Observable;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


class Glump extends Observable<Glump>
{
    private static final LinkedList<String>
        presents = new LinkedList<>(Arrays.asList("Football", "Pullover", "Teddy", "Chocolate", "Flowers"));
    
    private final String
        name;
    
    private int
        age;
    
    private String
        currentPresent = presents.peek();
    
    
    Glump(String name)
    {
        this.name = name;
    }
    
    public void becomeOlder()
    {
        this.age++;
        Collections.shuffle(presents);
        currentPresent = presents.peek();
        this.notifyObservers();
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getCurrentPresent()
    {
        return currentPresent;
    }
    
    @Override
    public Glump getIdentity()
    {
        return this;
    }
}
