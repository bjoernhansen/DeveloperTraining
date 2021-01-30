package com.design_pattern.memento;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class History
{
    private Deque<Memento> mememtos = new LinkedList<>();
    
    public void push(Memento memento)
    {
        mememtos.addFirst(memento);
    }
    
    public Optional<Memento> pop()
    {
        return Optional.ofNullable(mememtos.removeFirst());
    }
}
