package com.annotation.effective_java;

public class Sample
{
    @BjoernTest
    public static void test1()
    {

    }

    @BjoernTest
    public static void test2()
    {
        throw new RuntimeException("Bjoerns misktake!");
    }

    @BjoernTest
    public static void test3(int i)
    {

    }


    public static void test4()
    {

    }


    public static void test5()
    {
        throw new RuntimeException("Bjoerns misktake!");
    }

    @BjoernTest
    private static void test6()
    {

    }
}
