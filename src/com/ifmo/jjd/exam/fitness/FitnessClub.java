package com.ifmo.jjd.exam.fitness;

import java.time.LocalDateTime;
import java.util.Arrays;

import static com.ifmo.jjd.exam.fitness.Settings.*;

public class FitnessClub {
    FitnessZone[] zones = new FitnessZone[3];

    //конструктор фитнес-клуба, создает зоны
    public FitnessClub() {
        this.zones[0] = new FitnessZone(FitnessZone.Name.ТРЕНАЖЕРНЫЙ_ЗАЛ);
        this.zones[1] = new FitnessZone(FitnessZone.Name.БАССЕЙН);
        this.zones[2] = new FitnessZone(FitnessZone.Name.ГРУППОВЫЕ_ЗАНЯТИЯ);
    }

    //метод посещения фитнес-клуба. посетитель сообщает зону и предъявляет абонемент
    public void visiting (FitnessZone zone, SeasonTicket ticket) {
        //проверяет открыт ли клуб
        if (Validations.clubIsOpen()) {
            //проверяет валиден ли абонемент
            if (Validations.checkTicket(ticket)) {
                // проверяет, включает ли абонемент запрашиваемую зону с учетом времени
                if (Validations.checkTicketInTheZoneNow(ticket, zone)) {
                    //проверяет не зарегистрирован ли абонемент сейчас в другой зоне, и если находит - удаляет
                    for (int i = 0; i < zones.length; i++) {
                        int tmp = zones[i].isTicketHere(ticket);
                        if (tmp >= 0) zones[i].removeSeasonTicket(tmp);
                    }
                    //добавляет посетителя в клуб в нужную зону
                    zone.addSeasonTicket(ticket);
                }
            }
        }
    }

    //клуб закрывается
    public void isClosing (){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < ZONE_CAPABILITY; j++) {
                this.zones[i].tickets[j] = null ;
            }
        }
        System.out.println("клуб закрывается");
    }

    //метод выводит информацию о посетителях клуба
    public void printCustomersInfo () {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.zones[i].name + ":");
            for (int j = 0; j < ZONE_CAPABILITY; j++) {
                if (!(this.zones[i].tickets[j] == null)) System.out.println(this.zones[i].tickets[j].userInfo.firstName
                        + " " + this.zones[i].tickets[j].userInfo.lastName);
            }
        }
    }

    @Override
    public String toString() {
        return "FitnessClub{" +
                "zones=" + Arrays.toString(zones) +
                '}';
    }
}
