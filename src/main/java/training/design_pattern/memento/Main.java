package training.design_pattern.memento;

public class Main
{
    
    public static void main(String[] args)
    {
        ValueKeeper valueKeeper = new ValueKeeper();

        valueKeeper.setInteger(14);
        valueKeeper.setString("Test");
        valueKeeper.redo();
        System.out.println(valueKeeper);
    }
}
