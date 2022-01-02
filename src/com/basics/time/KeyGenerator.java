package com.basics.time;



import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class KeyGenerator {

    static final int MAX_MONTH_VALUE = Month.values().length;


    public static String getKeyFromDate(LocalDateTime dateTime) {
        return getKeyFromDate(dateTime.getMonthValue(), dateTime.getYear());
    }


    private static String getKeyFromDate(int month, int year) {
        return month + "_" + year;
    }

    public static List<String> getPastKeysFromDate(int monthInThePast)
    {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime currentReportDate = now.minusMonths(monthInThePast);

        List<String> reportKeys = new ArrayList<>();

        while(currentReportDate.isBefore(now))
        {
            reportKeys.add(KeyGenerator.getKeyFromDate(currentReportDate.getMonthValue(), currentReportDate.getYear()));
            currentReportDate = currentReportDate.plusMonths(1);
        }
        return reportKeys;
    }
}