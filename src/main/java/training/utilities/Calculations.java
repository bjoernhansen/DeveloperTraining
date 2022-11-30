package training.utilities;


import java.awt.geom.Point2D;
import java.util.Random;

public final class Calculations
{
    private static final double
        EPSILON = 0.000001;
    
    private final static double
        ROOT05 = Math.sqrt(2)/2.0;
    
    private final static Point2D
        ZERO_POINT = new Point2D.Float(0,0);
        
    private static final double
        FWHM_FACTOR = 2 * Math.sqrt(2 * ln(2));
    
    private static final Random
        random = new Random();
        
    private Calculations() throws Exception
    {
        throw new Exception();
    }

    public static int randomIntValue(int valueRange)
    {
        return random.nextInt(valueRange);
    }
    
    public static boolean tossUp()
    {
        return tossUp(0.5f);
    }
    
    public static boolean tossUp(float n)
    {
        return Math.random() < n;
    }
    
    private static double ln(double value){
        return Math.log(value)/Math.log(Math.E);
    }
    
    public static double nextGaussian(double avg, double fwhm){
        return avg + (fwhm/FWHM_FACTOR) * random.nextGaussian();
    }
    
    public static boolean fuzzyEqualsForDouble(double d1, double d2)
    {
        return Math.abs(d1 - d2) < EPSILON;
    }
}