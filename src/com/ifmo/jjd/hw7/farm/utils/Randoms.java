package com.ifmo.jjd.hw7.farm.utils;

public class Randoms {
    public static int getRandomInt (int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static int getRandomInt (int max) {
        return (int) (Math.random() * max) ;
    }


    public static String getRandomDomesticAnimal () {
        String[] domesticAnimals = {"Корова", "Кот", "Курица", "Кролик"} ;
        return domesticAnimals[(int)(Math.random() * domesticAnimals.length)] ;
    }
}
