package com.ifmo.jjd.lesson13.car;

import com.ifmo.jjd.lesson13.Student;

import java.util.Comparator;
import java.util.TreeSet;

public class CarComparing {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);


        //сортировать по price color brand

        Comparator<Car> comparator = new Car.PriceComparator().thenComparing(new Car.ColorComparator()
                .thenComparing(new Car.BrandComparator()));
        TreeSet<Car> carTreeSet = new TreeSet<>(comparator);

        carTreeSet.add(redOpel) ;
        carTreeSet.add(yellowMazda) ;
        carTreeSet.add(greenMazda) ;
        carTreeSet.add(blackOpel) ;

        System.out.println(carTreeSet);

    }
}