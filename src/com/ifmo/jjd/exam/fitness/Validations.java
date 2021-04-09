package com.ifmo.jjd.exam.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.ifmo.jjd.exam.fitness.Settings.*;

public class Validations {

    //метод проверяет валидность абонимента в конетной зоне с учетом времени.
    public static boolean checkTicketInTheZoneNow (SeasonTicket ticket, FitnessZone zone){
        switch (zone.name){
            case PULL:
                if (ticket.type == SeasonTicket.Type.FULL || ticket.type == SeasonTicket.Type.ONE_OFF) {
                    System.out.println("Абонемент включает Бассейн");
                    return true ;
                }
                System.out.println("Абонемент не включает бассейн");
                return false ;

            case GYM:
                if (ticket.type == SeasonTicket.Type.FULL || ticket.type == SeasonTicket.Type.ONE_OFF
                        || (ticket.type == SeasonTicket.Type.DAY && LocalTime.now().isBefore(TIME_VALID_TILL))) {
                    System.out.println("Абонемент включает Тренажерный зал");
                    return true ;
                }
                System.out.println("Ваш абонемент действителен на вход до 15:30");
                return false ;

            case GROUP_TRAININGS:
                if (ticket.type == SeasonTicket.Type.FULL
                        || (ticket.type == SeasonTicket.Type.DAY && LocalTime.now().isBefore(TIME_VALID_TILL)) ) {
                    System.out.println("Абонемент включает Групповые занятия");
                    return true ;
                }
                System.out.println("Абонемент не включает Групповые занятия или закончилось время действия");
                return false ;
        }
        System.out.println("что-то пошло не так...");
        return false;
    }

    //метод проверяет валиден ли абонимент (не вышел ли его срок действия)
    public static boolean checkTicket (SeasonTicket ticket) {
        if (ticket.validThrow.isAfter(LocalDate.now())) {
            System.out.println("абонемент действителен");
            return true ;
        }
        System.out.println("вышел срок действия абонемента");
        return false ;
    }

    // метод проверяет открыт ли клуб
    public static boolean clubIsOpen () {
        if (LocalTime.now().isBefore(TIME_CLOSE) && LocalTime.now().isAfter(TIME_OPEN))
            return true ;
        System.out.println("клуб закрыт. Рабочее время с 08:00 до 22:00");
        return false ;
    }
}
