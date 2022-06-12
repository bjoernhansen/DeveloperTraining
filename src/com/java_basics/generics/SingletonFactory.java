package com.java_basics.generics;

import java.util.function.UnaryOperator;

public class SingletonFactory
{
    private static final UnaryOperator<Object>
        IDENTITY_FUNCTION = (t) -> t;
    
    // Funktion ist typsicher, da Argument unverändert zurückgegeben wird
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> getIdentityFunction()
    {
        return (UnaryOperator<T>) IDENTITY_FUNCTION;
    }
    
    public static void main(String[] args)
    {
        UnaryOperator<String> sameString = getIdentityFunction();
        System.out.println(sameString.apply("Test string!"));
    }
}
