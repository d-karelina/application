package com.ifmo.jjd.hw7.farm;
import static com.ifmo.jjd.hw7.farm.Settings.*;

public class Fox extends WildAnimal implements HasSpeed, HasWeight{

protected Fox(){
        name = "Лиса";
        speed = setSpeed();
        weight = setWeight();
        attackScore = 10 ;
        scareOfFarmerScore = 0 ;
        }

// метод, который устанавливает случайное значение поля "скорость", в интервале от минимума до максимума
@Override
public int setSpeed() {
        return (this.speed = FOXES_SPEED);
        }

// метод, который устанавливает случайное значение поля "вес", в интервале от минимума до максимума
@Override
public int setWeight() {
        return (this.weight = FOXES_WEIGHT);
        }
}
