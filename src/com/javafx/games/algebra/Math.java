package com.javafx.games.algebra;

import java.util.Random;


public class Math
{
    /**
     * Bit mask to isolate the sign bit of a <code>double</code>.
     */
    public static final long    SIGN_BIT_MASK   = 0x8000000000000000L;
    
    /**
     * Bit mask to isolate the exponent field of a
     * <code>double</code>.
     */
    public static final long    EXP_BIT_MASK    = 0x7FF0000000000000L;
    
    /**
     * Bit mask to isolate the significand field of a
     * <code>double</code>.
     */
    public static final long    SIGNIF_BIT_MASK = 0x000FFFFFFFFFFFFFL;

    public static Random random = new Random();

    public static double max(double a, double b)
    {
        return (a >= b) ? a : b;
    }

    public static double min(double a, double b)
    {
        return (a <= b) ? a : b;
    }

    public static double signum(double d)
    {
        return (d == 0.0 || Double.isNaN(d)) ? d : copySign(1.0, d);
    }

    public static double copySign(double magnitude, double sign)
    {
        return Double.longBitsToDouble( (Double.doubleToRawLongBits(sign)
                & (SIGN_BIT_MASK))
                | (Double.doubleToRawLongBits(magnitude)
                        & (EXP_BIT_MASK
                                | SIGNIF_BIT_MASK)));
    }

    public static double sqrt(double a)
    {
        return StrictMath.sqrt(a);
    }
}
