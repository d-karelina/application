package com.ifmo.jjd.hw7.farm;

import static com.ifmo.jjd.hw7.farm.Settings.*;
import static com.ifmo.jjd.hw7.farm.utils.Randoms.getRandomInt;

public class Cat extends DomesticAnimal implements HasWeight, HasSpeed, HasHealth {

    protected Cat(){
        this.type = "Кот" ;
        setSpeed();
        setWeight();
        this.eatable = false ;
        this.resourcesAmount = CATS_RESOURCES ;
        this.health = CATS_HEALTH ;
    }

    // метод, который устанавливает случайное значение поля "вес", в интервале от минимума до максимума
    @Override
    public int setWeight() {
        return (this.weight = getRandomInt(CATS_WEIGHT_MIN, CATS_WEIGHT_MAX));
    }

    // метод, который устанавливает случайное значение поля "скорость", в интервале от минимума до максимума
    @Override
    public int setSpeed() {
        return (this.speed = getRandomInt(CATS_SPEED_MIN, CATS_SPEED_MAX));
    }

    //метод возвращает первоначальное здоровье
    @Override
    public int getStartHealth() {
        return CATS_HEALTH ;
    }

}
