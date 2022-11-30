package training.java_basics.time;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class classDate {
    private static final long TIME_OF_ONE_DAY = 24*60*60*1000;


    public static void main(String[] args) {

        Date date = new Date();
        List<Date> dates = new ArrayList<>();
        //dates.add(date);
        //dates.add(new Date(date.getYear(), date.getMonth(), date.getDate()));
        //dates.add(new Date(0));
        //dates.add(new Date(date.toGMTString()));
        dates.add(new Date("24 Jun 2020 02:25:48 GMT"));

        printAllDates(dates);
        addTimeOfOneDayToAllDates(dates);
        printAllDates(dates);
    }

    private static void addTimeOfOneDayToAllDates(List<Date> dates) {
        dates.forEach(classDate::addOneDay);
    }

    private static void addOneDay(Date date) {
        date.setTime(date.getTime()+ TIME_OF_ONE_DAY);
    }

    private static void printAllDates(List<Date> dates) {
        dates.forEach(classDate::printDate);
    }

    private static void printDate(Date date)
    {
        System.out.println("\nNächstes Datum");
        System.out.println("Zeit in ms: " + date.getTime());
        System.out.println("als String: " + date);
        System.out.println("Jahr: " + date.getYear());
        System.out.println("Monat: " + date.getMonth());
        System.out.println("Tag: " + date.getDate());
        System.out.println("Wochentag: " + DayOfWeek.of(date.getDay()).toString());
        System.out.println("GMT String: " + date.toGMTString());
        System.out.println();
    }
}