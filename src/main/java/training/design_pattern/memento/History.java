package training.design_pattern.memento;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class History
{
    private final Deque<Memento> mementos = new LinkedList<>();
    
    public void push(Memento memento)
    {
        mementos.addFirst(memento);
    }
    
    public Optional<Memento> pop()
    {
        return Optional.ofNullable(mementos.removeFirst());
    }
}
