package training.concurrency;

public class VariableNumber
{
    private int value;


    public VariableNumber(){ }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getAndIncrement()
    {
        return ++value;
    }
}