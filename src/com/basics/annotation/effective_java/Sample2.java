package com.basics.annotation.effective_java;

public class Sample2
{
    @ExceptionTest(ArithmeticException.class)
    public static void method1()
    {
        int i = 0;
        i = i/i;
    }

    @ExceptionTest({ArithmeticException.class, NullPointerException.class})
    public static void method2a()
    {
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArrayIndexOutOfBoundsException.class)
    public static void method2b()
    {
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void method3()
    {

    }
}
