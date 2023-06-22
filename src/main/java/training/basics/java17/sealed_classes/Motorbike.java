package training.basics.java17.sealed_classes;


public record Motorbike(int numberOfSeats, String registrationNumber) implements Service
{
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    
    @Override
    public int getMaxServiceIntervalInMonths()
    {
        return 9;
    }
}