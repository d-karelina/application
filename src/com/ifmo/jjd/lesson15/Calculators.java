package com.ifmo.jjd.lesson15;

public class Calculators {
    public static double simpleOperation (double a, double b, Operation operation) {
        return operation.execute(a,b) ;
    }
}
