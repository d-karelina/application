package com.ifmo.jjd.hw7.farm;

import static com.ifmo.jjd.hw7.farm.Settings.*;

public class Wolf extends  WildAnimal implements HasSpeed, HasWeight{

    protected Wolf(){
        name = "волк" ;
        speed = setSpeed() ;
        weight = setWeight() ;
        attackScore = 10 ;
        scareOfFarmerScore = 0 ;
    }

    // метод, который устанавливает случайное значение поля "скорость", в интервале от минимума до максимума
    @Override
    public int setSpeed() {
        return (this.speed = WOLFS_SPEED);
    }

    // метод, который устанавливает случайное значение поля "вес", в интервале от минимума до максимума
    @Override
    public int setWeight() {
        return (this.weight = WOLFS_WEIGHT);
    }
}
