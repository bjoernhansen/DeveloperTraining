package training.basics.java17.sealed_classes;


sealed interface Service permits Car, Truck, Motorbike
{
    
    
    int getMaxServiceIntervalInMonths();
    
    
    default int getMaxDistanceBetweenServicesInKilometers()
    {
        return 100000;
    }
}
