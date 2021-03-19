package lesson2;

import java.util.Scanner;

public class SecondClass {
    public static void main(String[] args) {
        //консольный ввод psvm
        Scanner enter = new Scanner(System.in); //Skaner - тип данных, in - название переменной,
        // new Scanner - новый объект класса Scanner. Класс сканнер - в другом пакете,
        // который автоматически подключается в начале программы.
/*
        System.out.println("введите значение") ;
        int userNum = enter.nextInt(); // Int - нужный тип данных
        System.out.println(userNum);
    //    if
    int state = 0 ;
    if (state== 0) {
        System.out.println("закрытие приложения");
    } else if (state == 1) {
        System.out.println("открытие приложения");
    } else {
        System.out.println("ошибка статуса");
    }
    *//*
    Даны переменные age и exp
    если значение переменной age больше 100
    вывести "Мы Вам перезвоним"
    в противном случае перейти к проверке exp:
    если exp меньше 5, вывести "Вы подходите на должность стажера"
    в противном случае, вывести "Вы подходите на должность разработчика"
     *//*

        System.out.println("введите возраст");
        int age = enter.nextInt() ;
        System.out.println("введите опыт");
        int exp = enter.nextInt();

        if (age<=16 || exp > age) System.out.println( "вы нам не подходите или некорретный ввод");
        else if (age>100) System.out.println("Мы вам перезвоним");
        else if (exp < 5) System.out.println("Вы подходите на должность стажера");
        else System.out.println("Вы подходите на должность разработчика");

        int sum = 1000, code = 5984 ;
        // 4692 - 30%
        // 7024, 5984 = 20%
        // 1235, 7351, 9835 - 10%

        switch (code) {
            case 4692 :
                System.out.println(sum*0.7);
                break ;
            case 7024 :
            case 5984 :
                System.out.println(sum*0.8);
                break ;
            case 1235 :
            case 7351 :
            case 9835 :
                System.out.println(sum*0.9);
                break;
            default:
                System.out.println(sum);
                break;
        }
//дан номер месяца, в котором в зависимости от номера месяца вывести время года

        System.out.println("введите номер месяца");
        int month = enter.nextInt() ;
        switch (month) {
            case 1 :
            case 2:
            case 12:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("некорректный ввод");
                break;
        }
// пользователь вводит целое число с клавиатуры
//        необходимо вывести это число увеличенное на 2
//        если пользователь ввел 0, цикл прерывает работу
        while (true) {
            System.out.println("введите число");
            int num = enter.nextInt();
            System.out.println(num + 2);
            if (num == 0)
                break ;
        }
//        вывести все четные числа от start до end
        int start = 1, end = 14;
        while (start!=end) {
            if (start % 2 == 0 ) System.out.println( start );
            start++ ;
        }
        int start = 1 , end = 14 ;
        if (start % 2 == 1 ) start++ ;
        for (int i = start; i < end+1; i=i+2) {
            System.out.println( start );
            start=start+2 ;
        }

        int start = 1 , end = 14 ;
        if (start % 2 == 1 ) start++ ;
        while (start <= end) {
            System.out.println(start);
            start +=2;
        }

        for (int start = 1 , end = 14 ; start<end; start++) {
            if (start % 2 == 0) System.out.println(start);
        }
//        вывести все положительные элементы последовательности 95 90 85 80...
        for (int i = 95 ; i > 0 ; i -= 5 )
            System.out.println(i);
//        вывести на экран перве 20 элементов последовательности 2 4 6 8 10 ...

        for (int num = 2, i = 1 ; i<=20 ; i++, num+=2 )
            System.out.print(num + " ") ;*/


    }
}
