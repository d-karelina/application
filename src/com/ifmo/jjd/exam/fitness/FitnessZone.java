package com.ifmo.jjd.exam.fitness;

import java.util.Arrays;

import static com.ifmo.jjd.exam.fitness.Settings.*;

public class FitnessZone {
    final Name name ;
    SeasonTicket[] tickets = new SeasonTicket[ZONE_CAPABILITY] ;

    protected FitnessZone(Name name) {
        this.name = name ;
    }

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

    protected void removeSeasonTicket (SeasonTicket ticket) {
        for (int i = 0; i < ZONE_CAPABILITY; i++) {
            if (tickets[i] == ticket) {
                tickets[i] = null ;
                System.out.println("абонимент успешно удален из зоны " + this.name );
                return;
            }
        }
        System.out.println("что-то пошло не так...");
    }

    protected void addSeasonTicket (SeasonTicket ticket) {
        int available = checkAvailability();
        if (available >= 0 ) {
            tickets[available] = ticket ;
            System.out.println("абонимент успешно добавлен в зону фитнес-клуба");
            return;
        }
        System.out.println("что-то пошло не так...");
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
