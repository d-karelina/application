package com.ifmo.jjd.exam.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.ifmo.jjd.exam.fitness.Settings.*;

public class Validations {

    //метод проверяет валидность абонимента в конетной зоне с учетом времени.
    public static boolean checkTicketInTheZoneNow (SeasonTicket ticket, FitnessZone zone){
        switch (zone.name){
            case БАССЕЙН:
                if (ticket.type == SeasonTicket.Type.ПОЛНЫЙ || ticket.type == SeasonTicket.Type.РАЗОВЫЙ) {
                    System.out.println("Абонемент включает Бассейн");
                    return true ;
                }
                System.out.println("Абонемент не включает бассейн");
                return false ;

            case ТРЕНАЖЕРНЫЙ_ЗАЛ:
                if (ticket.type == SeasonTicket.Type.ПОЛНЫЙ || ticket.type == SeasonTicket.Type.РАЗОВЫЙ
                        || (ticket.type == SeasonTicket.Type.ДНЕВНОЙ && LocalTime.now().isBefore(TIME_VALID_TILL))) {
                    System.out.println("Абонемент включает Тренажерный зал");
                    return true ;
                }
                System.out.println("Ваш абонемент действителен на вход до 15:30");
                return false ;

            case ГРУППОВЫЕ_ЗАНЯТИЯ:
                if (ticket.type == SeasonTicket.Type.ПОЛНЫЙ
                        || (ticket.type == SeasonTicket.Type.ДНЕВНОЙ && LocalTime.now().isBefore(TIME_VALID_TILL)) ) {
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
