package com.ifmo.jjd.hw7.farm;

import static com.ifmo.jjd.hw7.farm.Settings.*;
import static com.ifmo.jjd.hw7.farm.utils.Randoms.*;

public class Farmer {
    //переменная для ресурсов фермера. Присваивается стартовое значение.
    int resources = START_RESOURCES;


    //метод сбора ресурсов с животных
    public void collectResources (DomesticAnimal... domesticAnimals){
        for (int i = 0; i < domesticAnimals.length; i++) {
            this.resources += domesticAnimals[i].resourcesAmount ;
        }
    }

    //метод, в котором фермер съедает съедобное домашнее животное с фермы и получает 1 ресурс за каждый кг массы
    public void eatDomesticAnimal (DomesticAnimal... domesticAnimals) {
        for (int i = 0; i < domesticAnimals.length; i++) {
            if (domesticAnimals[i].eatable && domesticAnimals[i].onFarm) {
                resources += domesticAnimals[i].weight ;
                domesticAnimals[i].onFarm = false ;
                break ;
            };
        }
    }

    //метод кормления животных
    public void feedDomesticAnimal (DomesticAnimal animal) {
        animal.eatFeed();
    }

    //мотод прогона диких животных
    public boolean banishWildAnimal (WildAnimal wildAnimal){
        int chance = getRandomInt(0,1);
        if (chance == 1) {
            wildAnimal.scareOfFarmerScore ++ ;
            System.out.println("фермер прогнал " + wildAnimal.name);
            return true ;
        }
        else return false ;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "resources=" + resources +
                '}';
    }
}
