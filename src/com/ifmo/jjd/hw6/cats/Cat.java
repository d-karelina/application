package com.ifmo.jjd.hw6.cats;
/*Класс кот:
Свойства: имя, цвет, скорость, вес, пойманные мыши;
Кот хранит информацию о пойманных мышах (максимум 100).
Метод: Кот ловит мышь, только, если его скорость выше, чем у мыши.
Метод: Кот может напасть на другого кота и, если он больше противника (по весу),
то может отобрать его мышей (если скорость мыши выше, чем скорость кота, она убежит),
массив с мышами противника нужно обнулить (всем элементам присвоить значение null).*/

import java.util.Arrays;

public class Cat {
    private String catsName ;
    private String catsColor ;
    private int catsSpeed ;
    private int catsWeight ;
    private Mouse[] catsMice = new Mouse[100];

    public Mouse[] getCatsMice() {
        return catsMice;
    }

    public Cat (String catsName, String catsColor, int catsSpeed, int catsWeight) {
        if (catsName == null || catsColor == null || catsSpeed < 1 || catsWeight < 1) {
            throw new IllegalArgumentException("один из параметров задан неверно: catsName and catsColor not null, " +
                    "catsSpeed and catsWieght >= 1");
        }
        this.catsName = catsName ;
        this.catsColor = catsColor ;
        this.catsSpeed = catsSpeed ;
        this.catsWeight = catsWeight ;
    }

    private void addMouseToMemory (Mouse mouse) {
        for (int i = 0; i < catsMice.length; i++) {
            if (catsMice[i] == null) {
                catsMice[i] = mouse;
                System.out.println("кот " + this.catsName + " запомнил ещё одну мышь.");
                return;
            }
            i++ ;
        }

        System.out.println("кот " + this.catsName + ": 'Слишком много мышей, чтобы их запоминать...'");
    }

    public void catchMouse (Mouse mouse){
        if (this.catsSpeed > mouse.getMousesSpeed()) {
            System.out.println("кот " + this.catsName + " поймал мышь!");
            this.addMouseToMemory(mouse);
            return;
        }

        System.out.println("кот " + this.catsName + ": 'мышь бегает быстрее...'");


    }

    public void fightCat (Cat catEnemy) {
        if (this.catsWeight > catEnemy.catsWeight) {
            System.out.println("кот "+ this.catsName + " побил кота " + catEnemy.catsName);
            grabMice(this , catEnemy);
            return ;
        }
        else {
            System.out.println("кот "+ this.catsName + "не одалел кота " + catEnemy.catsName);
            return ;
        }
    }

    public void grabMice (Cat catWinner, Cat catLooser) {
        for (int i = 0; i < catLooser.catsMice.length; i++) {
            if (!(catLooser.catsMice[i] == null))
                for (int j = 0; j < catWinner.catsMice.length; j++) {
                    if (catWinner.catsMice[j] == null) {
                        catWinner.catchMouse(catLooser.catsMice[i]);
                        break ;
                    }
                    j++ ;
                }
            catLooser.catsMice[i] = null ;
            i++ ;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catsName='" + catsName + '\'' +
                ", catsColor='" + catsColor + '\'' +
                ", catsSpeed=" + catsSpeed +
                ", catsWeight=" + catsWeight +
                ", catsMice=" + Arrays.toString(catsMice) +
                '}';
    }
}
