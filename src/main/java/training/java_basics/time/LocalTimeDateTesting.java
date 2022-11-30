package training.java_basics.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalTimeDateTesting {

    static LocalDateTime tomorrow = LocalDateTime.now()
                                                 .plusDays(1);

    public static void main(String[] args) {
        final DateTimeFormatter isoInstantDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime dateThreeMonthAgo = LocalDateTime.now()
                                                       .minusMonths(3);
        System.out.println(dateThreeMonthAgo.format(isoInstantDateTimeFormat));
    }
}