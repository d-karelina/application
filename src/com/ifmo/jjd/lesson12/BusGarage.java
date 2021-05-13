package com.ifmo.jjd.lesson12;

class BusGarage extends Garage {
    void checkBus() {
        System.out.println(this.getCarOnService().getNum()) ; //Transport
    }
}

class TrainGarage extends Garage<Train> {
    void checkTrain() {
        System.out.println(this.getCarOnService()); //train
    }
}

class TransportGarage extends Garage<Transport> {
    void checkTrain() {
        System.out.println(this.getCarOnService()); //Transport
    }
}