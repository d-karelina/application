package com.ifmo.jjd.lesson11.primitive;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        // byte - class Byte
        // short - class Short
        // int - class Integer
        // long - class Long
        // boolean - class Boolean
        // float - class Float
        // double - class Double
        // char - class Character

        int count = 3421 ;
        Integer age = 56 ; // new Integer (56); - не использовать

        //автоупаковка и автораспаковка
        //автоупаковка
        Integer i = 50342 ; // = count ;

        //автораспаковка
        double price ;
        Double d = 67.9 ;
        price = d ;

        //ни автоупаковка, ни автораспаковка не работают с массивами

        Long first = 45L;
        Long second = 45L ;
        System.out.println(first == second); //true
        System.out.println(first.equals(second)); //true

        Long third = 300L ;
        Long fourth = 300L ;

        System.out.println(third == fourth); //false
        System.out.println(third.equals(fourth)); //true

        Integer a = 78 ;
        Integer b = 78 ;
        System.out.println(a.compareTo(b));
        System.out.println(Integer.compare(b, a)); //(x < y) ? -1 : ((x == y) ? 0 : 1);

        System.out.println(Integer.hashCode(a)); //78

        //возвращает примитивы
        System.out.println(a.longValue()) ;
        System.out.println(a.intValue()) ;
        System.out.println(a.shortValue()) ;
        System.out.println(a.floatValue()) ;
        System.out.println(a.doubleValue()) ;
        System.out.println(a.byteValue()) ;

        //преобразование строки с числом к числу
        //parseXXX(строка с числом) - возвращает примитив
        //valueOf(строка_с_числом) - возвращает объект
        long l = Long.parseLong("567") ;
        Short s = Short.valueOf("22") ;

    }
}
