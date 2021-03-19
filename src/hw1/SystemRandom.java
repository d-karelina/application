package hw1;

import java.util.Scanner;

/* Задача на Math.random() и if
        Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500]
        в интервал (25;200) и выводить результат в консоль.
        Примеры работы программы:
        Число 345 не содержится в интервале (25;200)
        Число 110 содержится в интервале (25;200)*/

public class SystemRandom {
    public static void main(String[] args) {
        int random;
        double randomMini ;
        do {
            randomMini = Math.random() ;
            System.out.println(randomMini);
            random = (int) (randomMini * 1000);
            System.out.println(random);
        }
        while (random < 10 || random > 500) ;

        if (random > 25 && random < 200) System.out.println("Число " + random + " содержится в интервале");
        else System.out.println("Число " + random + " не содержится в интервале");

    }
}
