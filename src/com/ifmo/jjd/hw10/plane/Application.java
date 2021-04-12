package com.ifmo.jjd.hw10.plane;
/*
* Задача 1
Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).

Время в пути Сидней -  Хьюстон - 15 часов 35 минут
Время ожидания в аэропорту Хьюстона - 1 час
Время в пути  Хьюстон - Вашингтон - 2 часа 49 минут
Время ожидания в аэропорту Вашингтона - 1 час 10 минут
Время в пути Вашингтон - Оттава - 1 час 40 минут

Вывести в консоль:
Время прибытия! в аэропорт Оттавы (время местное для Оттавы)
Время вылета! из аэропорта Хьюстона (время местное для Хьюстона)
Время вылета! из аэропорта Вашингтона (время местное для Вашингтона)*/


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.parse("2020-06-16T19:00:00");

        List<String> zones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        //zones.forEach(System.out::println);

        ZonedDateTime startTimeInZone = startTime.atZone(ZoneId.of("Australia/Melbourne")) ;

        ZonedDateTime arrivalToHouston = startTimeInZone.plusHours(15).plusMinutes(35) ;
        arrivalToHouston = arrivalToHouston.withZoneSameInstant(ZoneId.of("America/Chicago")) ;

        ZonedDateTime departureToWashington = arrivalToHouston.plusHours(1);
        ZonedDateTime arrivalToWashington = departureToWashington.plusHours(2).plusMinutes(49)
                .withZoneSameInstant(ZoneId.of("America/New_York"));

        ZonedDateTime departureToOttawa = arrivalToWashington.plusHours(1).plusMinutes(10) ;
        ZonedDateTime arrivalToOttawa = departureToOttawa.plusHours(1).plusMinutes(40)
                .withZoneSameInstant(ZoneId.of("America/Toronto"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(startTimeInZone);
        System.out.println(arrivalToHouston);
        System.out.println("Время вылета! из аэропорта Хьюстона: " + formatter.format(departureToWashington));
        System.out.println(arrivalToWashington);
        System.out.println("Время вылета! из аэропорта Вашингтона: " + formatter.format(departureToOttawa));
        System.out.println("Время прибытия! в аэропорт Оттавы: " + formatter.format(arrivalToOttawa));
    }
}
