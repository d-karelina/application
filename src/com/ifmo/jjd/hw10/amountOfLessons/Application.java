package com.ifmo.jjd.hw10.amountOfLessons;
/*Задача 3
Допустим, наше последнее занятие состоится 16 июня 2021 года.
Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт)?
Когда состоится защита диплома, если на подготовку дается 2 недели?*/

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Application {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate last = LocalDate.of(2021, Month.JUNE, 17);

        int count = 0;

        for (LocalDate i = now; i.isBefore(last) ; i=i.plusDays(1)) {
            if (i.getDayOfWeek() == DayOfWeek.MONDAY || i.getDayOfWeek() == DayOfWeek.WEDNESDAY
                    || i.getDayOfWeek() == DayOfWeek.FRIDAY) count++ ;
        }
        System.out.println("осталось " + count + " занятий");

        LocalDate exam = last.plusWeeks(2) ;

        System.out.println("Экзамен состоится " + exam);

    }
}
