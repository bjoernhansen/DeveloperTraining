package training.design_pattern.memento;


public class Originator
{
    private String
        string;
    
    private Integer
        integer;
    
    private final History
        history = new History();
    
    
    Originator(String string, Integer integer)
    {
        this.integer = integer;
        this.string = string;
    }
    
    public void redo()
    {
        if(!history.isEmpty())
        {
            Memento memento = history.pop();
            this.string = memento.string();
            this.integer = memento.integer();
        }
    }
    
    public String getString()
    {
        return string;
    }
    
    public void setString(String string)
    {
        this.saveState();
        this.string = string;
    }
    
    public Integer getInteger()
    {
        return integer;
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
        return String.format("Originator: %s, %d", this.string, this.integer);
    }
}
