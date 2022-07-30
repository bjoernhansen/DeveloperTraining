package com.java_basics.time;

public final class Time
{
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    private final int hour;
    private final int minute;

    public Time(int hour, int minute)
    {
        if(hour < 0 || hour >= HOURS_PER_DAY)
        {
            throw new IllegalArgumentException("Hour: " + hour);
        }
        if(minute < 0 || hour >= MINUTES_PER_HOUR)
        {
            throw new IllegalArgumentException("Min: " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}