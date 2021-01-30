package com.observing.listener;

import java.util.EventObject;

public class BirthdayEvent extends EventObject
{
    private String present;

    public BirthdayEvent(Object source, String present)
    {
        super(source);
        this.present = present;
    }

    public String getPresent()
    {
        return this.present;
    }
}
