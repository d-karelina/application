package com.ifmo.jjd.exam.fitness;

import java.time.LocalDateTime;
import java.util.Arrays;

import static com.ifmo.jjd.exam.fitness.Settings.*;

public class FitnessZone {
    final Name name ;
    SeasonTicket[] tickets = new SeasonTicket[ZONE_CAPABILITY] ;

    protected FitnessZone(Name name) {
        this.name = name ;
    }

    //метод проверяет есть ли места в зоне фитнесс-клуба
    protected int checkAvailability () {
        for (int i = 0; i < ZONE_CAPABILITY; i++) {
            if (tickets[i] == null) {
                System.out.println("места есть");
                return i;
            }
        }
        System.out.println("мест нет");
        return -1 ;
    }

    // проверяет есть ли такой абонемент в зоне, при наличии возвращает номер элемента, при отсутсвии - (-1)
    protected int isTicketHere (SeasonTicket ticket) {
            for (int i = 0; i < ZONE_CAPABILITY; i++) {
                if (tickets[i] == ticket) {
                    return i;
                }
            }
            return -1 ;
    }

    //удаляет абонемент из зоны по переданному номеру элемента
    protected void removeSeasonTicket (int i) {
        tickets[i] = null ;
        System.out.println("абонемент успешно удален из зоны: " + this.name );
    }

    //добавляет абонемент в зону, выводит информацию о посещении клуба
    protected void addSeasonTicket (SeasonTicket ticket) {
        int available = checkAvailability();
        if (available >= 0 ) {
            tickets[available] = ticket ;
            System.out.println("-----------------------");
            System.out.println(ticket.userInfo.firstName);
            System.out.println(ticket.userInfo.lastName);
            System.out.println(this.name);
            System.out.println(LocalDateTime.now());
            System.out.println("-----------------------");
        }
    }

    @Override
    public String toString() {
        return  "tickets=" + Arrays.toString(tickets) +
                '}';
    }

    enum Name{
        БАССЕЙН, ТРЕНАЖЕРНЫЙ_ЗАЛ, ГРУППОВЫЕ_ЗАНЯТИЯ
    }
}
