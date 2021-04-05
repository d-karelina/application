package com.ifmo.jjd.hw7.farm;

import java.util.Objects;

import static com.ifmo.jjd.hw7.farm.utils.Randoms.getRandomDomesticAnimal;

public class Application {
    public static void main(String[] args) {


     // для проверки корректности создания домашних животных убрать комменатрий.

/*        DomesticAnimal animal1 = DomesticAnimal.createDomesticAnimal("Кролик");
        DomesticAnimal animal2 = DomesticAnimal.createDomesticAnimal("Кот");
        DomesticAnimal animal3 = DomesticAnimal.createDomesticAnimal("Корова");
        DomesticAnimal animal6 = DomesticAnimal.createDomesticAnimal("Курица");
        DomesticAnimal animal4 = DomesticAnimal.createDomesticAnimal("кто-нибудь");
        DomesticAnimal animal5 = DomesticAnimal.createDomesticAnimal(getRandomDomesticAnimal());

        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal6);
        System.out.println(animal4);
        System.out.println(animal5);*/

        Farm farm1 = new Farm();

        //System.out.println(farm1);

        farm1.dayOnFarm();

    }
}
