package com.ifmo.jjd.hw7.farm;

import java.util.Arrays;

import static com.ifmo.jjd.hw7.farm.Settings.*;
import static com.ifmo.jjd.hw7.farm.utils.Randoms.getRandomDomesticAnimal;

public class Farm {
    Farmer farmer;
    DomesticAnimal[] animalsOnFarm = new DomesticAnimal[FARM_CAPABILITY];

    public Farm(){
        farmer = new Farmer();
        for (int i = 0; i < animalsOnFarm.length; i++) {
            animalsOnFarm[i] = DomesticAnimal.createDomesticAnimal(getRandomDomesticAnimal());
        }

    }

    //метод, который проверяет наличие животных на ферме, которые дают ресурсы
    private boolean checkResourcesAnimals (){
        for (int i = 0; i < animalsOnFarm.length; i++) {
            if (animalsOnFarm[i].isAlive() && animalsOnFarm[i].resourcesAmount != 00)
                return true ;
        }
        return false ;
    }

    //метод день на ферме
    public void dayOnFarm(){

        //фермер тратит ресурсы
        farmer.resources -= 2;
        System.out.println("фермер потратил ресуры");

        //проверяем закончились ли ресурсы, если нет - продолжаем...
        if (farmer.resources <= 0) {
            System.out.println("gameover");
            return;
        }

        //приходит дикое животное, рандомно его прогоняет или нет фермер,
        // если нет, то дикое животное атакует случайное домашнее животное,
        // домашнее животное пытается убежать. если не вышло - дикое животное атакует домашнее.

        //фермер кормит всех животных
        for (int i = 0; i < animalsOnFarm.length; i++) {
            farmer.feedDomesticAnimal(animalsOnFarm[i]);
        }

        System.out.println("фермер покормил животных");

        //если на ферме остались ресурсные животные, фермер собирает ресурсы. Если нет - есть животное.
        if (checkResourcesAnimals()) {
            farmer.eatDomesticAnimal(animalsOnFarm) ;
            System.out.println("фермер собрал ресурсы");
        }
        else {
            farmer.collectResources(animalsOnFarm);
            System.out.println("фермер съел животное");
        }
    }

    @Override
    public String toString() {
        return "Farm{" +
                "farmer=" + farmer +
                ", animalsOnFarm=" + Arrays.toString(animalsOnFarm) +
                '}';
    }
}
