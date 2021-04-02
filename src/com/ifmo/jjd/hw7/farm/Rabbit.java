package com.ifmo.jjd.hw7.farm;

import static com.ifmo.jjd.hw7.farm.Settings.*;
import static com.ifmo.jjd.hw7.farm.utils.Randoms.getRandomInt;

public class Rabbit extends DomesticAnimal implements HasSpeed, HasWeight, HasHealth{
    protected Rabbit(){
        this.type = "Кролик" ;
        setSpeed();
        setWeight();
        this.eatable = true ;
        this.resourcesAmount = RABBITS_RESOURCES;
        this.health = RABBITS_HEALTH;
    }

    // метод, который устанавливает случайное значение поля "скорость", в интервале от минимума до максимума
    @Override
    public int setSpeed() {
        return (this.weight = getRandomInt(RABBIT_SPEED_MIN, RABBIT_SPEED_MAX));
    }

    // метод, который устанавливает случайное значение поля "вес", в интервале от минимума до максимума
    @Override
    public int setWeight() {
        return (this.weight = getRandomInt(RABBIT_WEIGHT_MIN, RABBIT_WEIGHT_MAX));
    }

    //метод возвращает первоначальное здоровье
    @Override
    public int getStartHealth() {
        return RABBITS_HEALTH;
    }
}
