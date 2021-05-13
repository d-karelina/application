package com.ifmo.jjd.lesson10.enums;

public enum Planet {
    MERCURY(326, 242),
    VENUS(488, 510),
    EARTH(529, 473),
    MARS(643, 388),
    JUPITER (1010, 713),
    SATURN (869, 238),
    NEPTUNE (657, 654),
    URANUS (434, 657);

    int weight ;
    int radius ;

    Planet(int weight, int radius) {
        this.weight = weight;
        this.radius = radius;
    }

    public int getWeight() {
        return weight;
    }

    public int getRadius() {
        return radius;
    }
}
