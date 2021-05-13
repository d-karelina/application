package com.ifmo.jjd.lesson21.patterns.listener;

import java.util.Scanner;
import com.ifmo.jjd.lesson21.patterns.builder.NutritionFacts ;

public class Command {
    public static void main(String[] args) {

        Listener listener1 = new Listener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("listener1 greenEvent " + code) ;
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("listener1 yellowEvent " + code) ;
            }

            @Override
            public void redEvent(int code) {
                System.out.println("listener1 redEvent " + code) ;
            }
        };

        Listener listener2 = new Listener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("listener2 greenEvent " + code) ;
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("listener2 yellowEvent " + code) ;
            }

            @Override
            public void redEvent(int code) {
                System.out.println("listener2 redEvent " + code) ;
            }
        };

        StateClass stateClass = new StateClass() ;
        stateClass.addListener(listener1) ;
        stateClass.addListener(listener2) ;

        Scanner scanner = new Scanner(System.in) ;
        String state ;
        while (true) {
            System.out.println("Введите статус") ;
            state = scanner.nextLine() ;
            if ("exit".equals(state)) break;
            stateClass.changeState(state);
        }

       //builder
       NutritionFacts apple = new NutritionFacts.Builder(3)
               .calories(100)
               .fat(3)
               .build() ;
    }
}
