package com.observing.listener;

public class GlumPrinter implements BirthdayListener
{
    private String name;
    private int age;
    private String lastBirthdayPresent;


    GlumPrinter(Glump glump)
    {
        this.name = glump.getName();
        this.age = glump.getAge();
        glump.addBirthdayListener(this);
    }

    @Override
    public String toString()
    {
        return String.format("My %d year old glump's name is %s and my last birthday present was %s.", this.age, this.name, this.lastBirthdayPresent);
    }


    @Override
    public void gifting(BirthdayEvent e)
    {
        Glump glump = (Glump)e.getSource();
        this.age = glump.getAge();
        this.lastBirthdayPresent = e.getPresent();
    }
}
