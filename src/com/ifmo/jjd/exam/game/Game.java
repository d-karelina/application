package com.ifmo.jjd.exam.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //создаем меню игры
        Menu menu = new Menu() ;
        //переменная, в которой отслеживаем не пора ли выходить
        boolean escape = false ;


        //в цикле выводим меню, считываем, проверяем и запускаем команду
        while (!escape) {
            menu.printMenu() ;
            Scanner scan = new Scanner(System.in) ;
            try {
                Command command = menu.readCommand(scan.nextInt()) ;
                if (!(command == null)) escape = command.execute() ;
            } catch (InputMismatchException e) {
                System.out.println("введенное значение некорректно! Введите номер из меню");
            }

        }
    }
}
