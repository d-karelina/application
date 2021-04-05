package com.ifmo.jjd.hw7.farm;

public class WildAnimal extends Animals implements HasSpeed, HasWeight{

    String name;
    int attackScore ;
    int scareOfFarmerScore ;

    protected WildAnimal() {};

    /*
    метод проверяет, не боится ли жикое животное идти на ферму.
    если фермер его трижды уже прогонял, то боится
    */
    public boolean isScared (){
        return this.scareOfFarmerScore >= 3? true : false ;
    }

    /*
    метод аттаки (ранения/съедания) домашнего животного.
    дикое животное атакует домашнее с помощью силы, которая вычитается из здоровья
    если у жиотного осталось здоровье - то, оно ранено, если нет - погибло
    */
    public void attack (DomesticAnimal domesticAnimal){
        if (domesticAnimal.runAway(this)) {
            System.out.println("домашнее животное убежало!");
            return;
        }
        domesticAnimal.health -= this.attackScore;
        if (domesticAnimal.health <= 0) {
            domesticAnimal.onFarm = false;
            System.out.println(this.name + "съел" + domesticAnimal.type);
            return;
        }
        System.out.println(this.name + "ранил" + domesticAnimal.type);
    }


    @Override
    public int setSpeed() {
        return 0;
    }

    @Override
    public int setWeight() {
        return 0;
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "weight=" + weight +
                ", speed=" + speed +
                ", name='" + name + '\'' +
                ", attackScore=" + attackScore +
                ", scareOfFarmerScore=" + scareOfFarmerScore +
                '}';
    }
}
