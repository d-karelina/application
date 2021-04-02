package com.ifmo.jjd.hw7.farm;

import static com.ifmo.jjd.hw7.farm.Settings.*;
import static com.ifmo.jjd.hw7.farm.utils.Randoms.getRandomInt;

public class Cow extends DomesticAnimal implements HasWeight, HasSpeed, HasHealth{

    protected Cow(){
        this.type = "Корова" ;
        setSpeed();
        setWeight();
        this.eatable = true ;
        this.resourcesAmount = COWS_RESOURCES ;
        this.health = COWS_HEALTH ;
    }

    // метод, который устанавливает случайное значение поля "скорость", в интервале от минимума до максимума
    @Override
    public int setSpeed() {
        return (this.speed = getRandomInt(COWS_SPEED_MIN, COWS_SPEED_MAX));
    }

    // метод, который устанавливает случайное значение поля "вес", в интервале от минимума до максимума
    @Override
    public int setWeight() {
        return (this.weight = getRandomInt(COWS_WEIGHT_MIN, COWS_WEIGHT_MAX));
    }

    //метод возвращает первоначальное здоровье
    @Override
    public int getStartHealth() {
        return COWS_HEALTH ;
    }
}
