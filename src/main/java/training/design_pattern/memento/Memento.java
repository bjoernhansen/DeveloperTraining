package training.design_pattern.memento;

public class Memento
{
    final private String string;
    final private Integer integer;
    
    public Memento(String string, Integer integer)
    {
        this.string = string;
        this.integer = integer;
    }
    
    public String getString()
    {
        return string;
    }
    
    public Integer getInteger()
    {
        return integer;
    }
}