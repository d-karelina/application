package com.ifmo.jjd.hw7.farm;

public abstract class Animals implements HasSpeed, HasWeight {
    protected int weight ;
    protected int speed ;

    protected Animals() {}

    /*public Animals(int weight, int speed) {
        if (weight <= 0 || speed <= 0) {
            throw new IllegalArgumentException("weight<=0 or speed<=0");
        }

        this.weight = weight;
        this.speed = speed;
    }*/
}
