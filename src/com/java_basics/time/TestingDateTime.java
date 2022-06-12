package com.java_basics.time;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;


public class TestingDateTime {

    private static final WeekFields GERMAN_WEEK_FIELDS = WeekFields.of(Locale.GERMANY);


    public static void main(String[] args) {

        LocalDate now = LocalDate.now();

        String start_hvk = date2YearCw(now);
        String end_hvk = date2YearCw(now.plusDays(14));

        System.out.printf("Date 1: %s; Date 2: %s%n", start_hvk, end_hvk);
    }

    private static String date2YearCw(LocalDate localDate) {
        return localDate.get(GERMAN_WEEK_FIELDS.weekBasedYear()) + String.format("%02d", localDate.get(GERMAN_WEEK_FIELDS.weekOfWeekBasedYear()));
    }
}
