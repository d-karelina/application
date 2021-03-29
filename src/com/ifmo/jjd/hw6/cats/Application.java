package com.ifmo.jjd.hw6.cats;
/*Реализовать объектную модель:
Кот: имя, цвет, скорость, вес, пойманные мыши;
Мышь: скорость.
Кот хранит информацию о пойманных мышах (максимум 100).
Кот ловит мышь, только, если его скорость выше, чем у мыши.
Кот может напасть на другого кота и, если он больше противника (по весу),
то может отобрать его мышей (если скорость мыши выше, чем скорость кота, она убежит),
массив с мышами противника нужно обнулить (всем элементам присвоить значение null).*/

public class Application {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Василий", "Red", 50, 4) ;
        Cat cat2 = new Cat("Матроскин", "Grey", 48, 5) ;

        Mouse mouse1 = new Mouse(48) ;
        Mouse mouse2 = new Mouse(47) ;

        cat1.catchMouse(mouse1) ;
        cat1.catchMouse(mouse2) ;

        cat2.fightCat(cat1) ;

        System.out.println(cat1) ;
        System.out.println(cat2) ;
    }
}
