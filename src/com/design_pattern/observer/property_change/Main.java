package com.design_pattern.observer.property_change;


import java.beans.PropertyVetoException;

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

        try {
            timo.setName("Tim");
            timo.setName("Tim");  // kein erneutes Feuern, da Name sich nicht geändert hat
            timo.setName("Klaus");  // Veto, da klaus
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }



        System.out.println(glumPrinter);
    }
}