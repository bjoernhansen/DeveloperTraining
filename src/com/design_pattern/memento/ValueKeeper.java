package com.design_pattern.memento;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class ValueKeeper
{
    private String string;
    private Integer integer;
    private final History history = new History();


    ValueKeeper()
    {
        this("", 0);
    }
    
    ValueKeeper(String string, Integer integer)
    {
        this.integer = integer;
        this.string = string;
    }
    
    public void redo()
    {
        Optional<Memento> lastState = history.pop();

        lastState.ifPresent(
                memento -> {
                    this.string = memento.getString();
                    this.integer = memento.getInteger();
                }
        );
    }
    
    public void setString(String string)
    {
        this.saveState();
        this.string = string;
    }

    public void setInteger(Integer integer)
    {
        this.saveState();
        this.integer = integer;
    }

    private void saveState()
    {
        history.push(new Memento(string, integer));
    }

    @Override
    public String toString()
    {
        return String.format("Current values: %s, %d",this.string, this.integer);
    }
}