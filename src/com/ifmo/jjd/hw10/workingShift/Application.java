package com.ifmo.jjd.hw10.workingShift;
/*Задача 2
Есть три рабочие смены :
с 7:00 до 15:00 утренняя
с 15:00 до 23:00 дневная
с 23:00 до 7:00 ночная
Определить, какая сейчас смена (относительно текущего времени)*/

import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {
        LocalTime shift1Start = LocalTime.of(7,0);
        LocalTime shift1End = LocalTime.of(14,59);
        LocalTime shift2Start = LocalTime.of(15,0);
        LocalTime shift2End = LocalTime.of(22, 59);
        LocalTime shift3Start = LocalTime.of(23,0);
        LocalTime shift3End = LocalTime.of(06, 59);

        LocalTime[][] shifts ;
        shifts = new LocalTime[][]{{shift1Start, shift1End},
                {shift2Start, shift2End},
                {shift3Start, shift3End}};

        for (int i = 0; i < shifts.length; i++) {
            if (LocalTime.now().isAfter(shifts[i][0]) && LocalTime.now().isBefore(shifts[i][1])) {
                System.out.println("Сейчас смена №" + (i+=1) );
                break;
            }
        }

    }
}
