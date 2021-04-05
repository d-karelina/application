package com.ifmo.jjd.exam.fitness;

import java.util.Arrays;

import static com.ifmo.jjd.exam.fitness.Settings.*;

public class FitnessClub {
    FitnessZone[] zones = new FitnessZone[3];

    public FitnessClub() {
        this.zones[0] = new FitnessZone(FitnessZone.Name.ТРЕНАЖЕРНЫЙ_ЗАЛ);
        this.zones[1] = new FitnessZone(FitnessZone.Name.БАССЕЙН);
        this.zones[2] = new FitnessZone(FitnessZone.Name.ГРУППОВЫЕ_ЗАНЯТИЯ);
    }

    public void visiting (FitnessZone zone, SeasonTicket ticket) {
        if (Validations.clubIsOpen()) {
            if (Validations.checkTicket(ticket)) {
                if (Validations.checkTicketInTheZoneNow(ticket, zone))
                    zone.addSeasonTicket(ticket);
            }
        }
    }

    public void isClosing (){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < ZONE_CAPABILITY; j++) {
                this.zones[i].tickets[j] = null ;
            }
        }
        System.out.println("клуб закрывается");
    }

    @Override
    public String toString() {
        return "FitnessClub{" +
                "zones=" + Arrays.toString(zones) +
                '}';
    }
}
