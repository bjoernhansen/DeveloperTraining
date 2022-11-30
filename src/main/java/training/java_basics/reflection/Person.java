package training.java_basics.reflection;

class Person
{
    private String name;
    private String vorname;
    private int alter;

    String getVorname()
    {
        return this.vorname;
    }

    void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    int getAlter()
    {
        return this.alter;
    }

    void setAlter(int alter)
    {
        this.alter = alter;
    }

    
    Person(String name)
    {
        super();
        this.setName(name);
    }

    String getName()
    {
        return this.name;
    }

    void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
           return "Person [name=" + name + "]"; 
    }
}
