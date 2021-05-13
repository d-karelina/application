package com.ifmo.jjd.lesson12;

//public class Garage<T extends Transport & Cloneable>

public class Garage<T extends Transport> {
    private T carOnService ;

    public void service() {
        carOnService.repair();
    }

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }
}