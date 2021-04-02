package com.ifmo.jjd.hw7.farm;

import static com.ifmo.jjd.hw7.farm.Settings.*;
import static com.ifmo.jjd.hw7.farm.utils.Randoms.getRandomInt;

public class Chicken extends DomesticAnimal implements HasWeight, HasSpeed, HasHealth{

    protected Chicken(){
        this.type = "Курица" ;
        setSpeed();
        setWeight();
        this.eatable = true ;
        this.resourcesAmount = CHICKEN_RESOURCES ;
        this.health = CHICKEN_HEALTH ;
    }

    // метод, который устанавливает случайное значение поля "скорость", в интервале от минимума до максимума
    @Override
    public int setSpeed() {
        return (this.speed = getRandomInt(CHICKEN_SPEED_MIN, CHICKEN_SPEED_MAX));
    }

    // метод, который устанавливает случайное значение поля "вес", в интервале от минимума до максимума
    @Override
    public int setWeight() {
        return (this.weight = getRandomInt(CHICKEN_WEIGHT_MIN, CHICKEN_WEIGHT_MAX));
    }

    //метод возвращает первоначальное здоровье
    @Override
    public int getStartHealth() {
        return CHICKEN_HEALTH ;
    }
}
