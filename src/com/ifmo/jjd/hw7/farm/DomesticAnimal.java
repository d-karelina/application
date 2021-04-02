package com.ifmo.jjd.hw7.farm;

/* Домашние животные: Корова, Кот, Курица, Кролик
        обладают следующими характеристиками:
        тип, вес, скорость, здоровье, флаг (пригодно в пищу или нет), количество ресурсов
        (у каждого свое и 0, если животное не дает ресурс). Ресурсы животных неизменны.
        Есть домашние животные, которые дают ресурсы:  Корова, Курица
        Есть домашние животные, которые пригодны в пищу: Кролик, Корова, Курица
        Домашнее животное может убежать от дикого животного, если его скорость больше.
        Домашнее животное может восполнять здоровье на 1, но не больше изначального.
        Животные восполняют здоровье во время кормления. */

import java.util.Objects;

import static com.ifmo.jjd.hw7.farm.utils.Randoms.*;

public abstract class DomesticAnimal extends Animals implements HasWeight, HasSpeed, HasHealth{

    protected String type ;
    protected int health;
    protected boolean eatable ;
    protected int resourcesAmount ;

    public boolean onFarm = true ;


    protected DomesticAnimal () {}

/*    protected DomesticAnimal(String type, int weight, int speed, boolean eatable, int resourcesAmount) {
        super(weight, speed);
        this.type = type ;
        this.resourcesAmount=resourcesAmount ;
        this.eatable = eatable ;
    }*/

    // фабричный метод, который создает домашнее животное, принимая на вход тип животного.
    // Если тип указан неверно - создается рандомное домашнее животное.
    // Значение полей домашнего животного устанавливаются в зависимости от предопределенных параметров.

    public static DomesticAnimal createDomesticAnimal(String type) {

        DomesticAnimal domesticAnimal = null ;

        switch (type) {
            case "Корова":
                domesticAnimal = new Cow() ;
                break;
            case "Кот":
                domesticAnimal = new Cat() ;
                break;
            case "Курица":
                domesticAnimal = new Chicken();
                break;
            case "Кролик":
                domesticAnimal = new Rabbit() ;
                break;
            default:
                domesticAnimal = createDomesticAnimal(getRandomDomesticAnimal());
                break;
        }
        return domesticAnimal;

    }

    // метод проверяет живо ли животное
    public boolean isAlive () {
        return (health > 0) ;
    }

    //метод, в котором животное принимает пищу и восполняет здоровье на 1.
    public void eatFeed () {
        if (this.isAlive())
        this.health = this.health+1 < this.getStartHealth() ? this.health+1: this.getStartHealth();
    }

    //метод, в котором животное может убежить, если его скорость больше скорости дикого животного
    public boolean runAway (WildAnimal wildAnimal){
        return (this.speed>wildAnimal.speed) ;
    }

    @Override
    public String toString() {
        return "DomesticAnimal{" +
                "weight=" + weight +
                ", speed=" + speed +
                ", onFarm=" + onFarm +
                ", type='" + type + '\'' +
                ", health=" + health +
                ", eatable=" + eatable +
                ", resourcesAmount=" + resourcesAmount +
                '}';
    }
}
