package com.javafx.games.algebra;

import java.util.Random;


public class Math
{
    public static Random random = new Random();

    public static double min(double a, double b)
    {
        return (a <= b) ? a : b;
    }
}
