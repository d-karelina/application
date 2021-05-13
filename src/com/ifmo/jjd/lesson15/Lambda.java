package com.ifmo.jjd.lesson15;

public class Lambda {
    public static void main(String[] args) {

        //Лямбда выражения
        // double execute(double a, double b) ;
        Operation minus = (x, y) -> x - y ;

        //если метод принимает на вход один аргумент, то круглые скобки можно не ставить.
        //во всех остальных круглые скобки ставить нужно
        //стрелка всегда ставится между аргументами и телом метода. стрелка указывает на то,
        //что это лямбда-выражение
        //если тело метода это одна инструкция  и метод возвращает какое-то значение,
        //то не ставится ни фигурные стробки, ни return.

        Operation div = (a, b) -> {
            if (b == 0) {
                System.out.println("Деление на ноль невозможно");
                return 0;
            }
            return a/b ;
        } ;
        System.out.println(minus.execute(5,7));
        System.out.println(div.execute(10, minus.execute(5, 7)));

        System.out.println(Calculators.simpleOperation(1,1, div));
        System.out.println(Calculators.simpleOperation(1,1, (a, b) -> a * b)) ;
    }
}
