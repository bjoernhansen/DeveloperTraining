package training.design_pattern.iterator;

public interface Iterator<T>
{
    boolean hasNext();

    T getCurrent();

    void next();
}
