package com.ifmo.jjd.lesson10.dateTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();
        current = current.plusSeconds(15);
        System.out.println(current);

        LocalDateTime date1 = LocalDateTime.parse("2022-04-01T14:00:00");

        boolean check = current.isBefore(date1);

        long between = ChronoUnit.DAYS.between(date1, current);

        System.out.println(between);

        between = Duration.between(date1, current).toDays() ;

        System.out.println(between);
    }
}
