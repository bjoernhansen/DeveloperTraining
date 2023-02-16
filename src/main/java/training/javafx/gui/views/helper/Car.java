package training.javafx.gui.views.helper;

public class Car
{
    private int year;
    
    private String make;
    
    
    public Car(int year, String make)
    {
        super();
        this.year = year;
        this.make = make;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public void setYear(int year)
    {
        this.year = year;
    }
    
    public String getMake()
    {
        return make;
    }
    
    public void setMake(String make)
    {
        this.make = make;
    }
    
    @Override
    public String toString()
    {
        return "Car [year=" + year + ", make=" + make + "]";
    }
}
