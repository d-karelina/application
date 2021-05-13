package com.ifmo.jjd.lesson15;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmbeddedFunctionalInterfaces {
    public static void main(String[] args) {

        //boolean test(T t) ;
        //проверка на положительное число
        //проверка на отрицательное число
        //проверка на четное число

        Predicate<Integer> check1 = x -> x > 0 ;
        Predicate<Integer> check2 = x -> x < 0 ;
        Predicate<Integer> check3 = x -> x % 2 == 0 ;

        System.out.println(check1.test(-9));
        System.out.println(check2.test(-9));
        System.out.println(check3.test(-9));

        System.out.println(check1.and(check3).test(12)); // AND
        System.out.println(check1.or(check2).test(0)); // OR
        System.out.println(check1.negate().test(-8)); // NOT !

        Function<Integer, Integer> sqrt = x -> x * x ;
        Function<Integer, String> convert = x -> x + "RUB" ;
        System.out.println(convert.apply(45)) ;

        // Consumer void <>;
    }
}
