package com.ifmo.jjd.lesson6;

import java.util.UUID;

public class Application {
    public static void main(String[] args) {
       Climber climber1 = new Climber() ;
        //обращение к свойствам объекта
        /*climber1.fullName = "Иван Григорьев" ;
        climber1.email = "i.grogoriev@mail.ru" ;
        climber1.age = 25 ;
        climber1.uuid = UUID.randomUUID() ; */
        //вызов методов
        climber1.setFullName("Иван Григорьевич") ;
        climber1.setAge(25) ;
        climber1.setEmail("i.grogoriev@mail.ru");
        climber1.setUuid();

        Climber climber3 = climber1.clone();
        System.out.println(climber3);
/*
        Climber climber2 = new Climber() ;
        //обращение к свойствам объекта
        *//*climber2.fullName = "Елена Михайлова" ;
        climber2.email = "mikhailova@gmail.com" ;
        climber2.age = 20 ;
        climber2.uuid = UUID.randomUUID() ;*//*

        climber2.setFullName("Елена Михайлова");
        climber2.setAge(30);
        climber2.setEmail("mikhailova@gmail.com");
        climber2.setUuid();

        int helenaAge = climber2.getAge() ;
        UUID helenaUuid = climber2.getUuid() ;

        System.out.println(climber1) ;
        System.out.println(climber2) ;*/

        Mountain everest = new Mountain("Эверест", 8000);
        Mountain elbrus = new Mountain("Эльбрус", 5642);
        //System.out.println(everest);
        //System.out.println(elbrus);
        Mountain monblant = elbrus.clone();

        System.out.println(monblant);
    }
}
