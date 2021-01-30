package com.observing.observer_observable;

import javafx.beans.property.SimpleStringProperty;

public class Main
{
    public static void main(String[] args)
    {
        Glump timo = new Glump("Timo");
        GlumPrinter glumPrinter = new GlumPrinter(timo);

        timo.addObserver(glumPrinter);

        System.out.println(glumPrinter);

        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();
        timo.becomeOlder();

        System.out.println(glumPrinter);
    }
}