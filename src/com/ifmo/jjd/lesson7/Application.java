package com.ifmo.jjd.lesson7;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /*
        Knight knight = new Knight(20, 12) ;
        Infantry infantry = new Infantry(34, 5) ;

        BattleUnit bUnit1 = new Knight(8,3) ;
        BattleUnit bUnit2 = new Infantry(13,7) ;

        //Knight bKnight = (Knight) bUnit1 ;

        Unit unit = new King() ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип юнита");
        String type = scanner.nextLine();

       BattleUnit battleUnit;

        battleUnit.attack(infantry);

        System.out.println(battleUnit.getAttackScore());*/

        King arthur = new King() ;
        King peter = new King() ;
        arthur.startBattle(peter);

        System.out.println(arthur);
        System.out.println(peter);

    }
}
