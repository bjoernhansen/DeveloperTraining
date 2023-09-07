package training.design_pattern.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class History
{
    private final Deque<Memento>
        mementos = new ArrayDeque<>();
    
    
    public void push(Memento memento)
    {
        mementos.addFirst(memento);
    }
    
    public Memento pop()
    {
        return mementos.pollFirst();
    }
    
    boolean isEmpty()
    {
        return mementos.isEmpty();
    }
}
