package com.observing.javafx_binding.glumpExample;

public class Main
{
    public static void main(String[] args)
    {
        Glump timo = new Glump("Timo");
        GlumPrinter glumPrinter = new GlumPrinter(timo);

        System.out.println(glumPrinter);

        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();

        timo.setName("Klaus");

        System.out.println(glumPrinter);
    }
}