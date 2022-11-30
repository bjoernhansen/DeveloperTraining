package training.concurrency;

public class Range
{
    private final int first;
    private final int last;


    private Range(int first, int last)
    {
        this.first = first;
        this.last = last;
    }

    public static Range of(int first, int last)
    {
        return new Range(first, last);
    }

    public boolean contains(int value)
    {
        return value >= first && value <= last;
    }

    public boolean isBelow(int value)
    {
        return last < value;
    }

    @Override
    public String toString()
    {
        return String.format("[%d, %d]", first, last);
    }

    public int getLowerBound() {
        return last;
    }
}